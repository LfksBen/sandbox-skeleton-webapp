package com.cbp.disponibilite.gestionnaires.database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 * Liquibase class.
 */
public class LiquibaseUpdater {

    /** Path for DB Changelog. */
    private static final String DB_CHANGELOG = "database/liquibase/changelog-master.xml";

    /** The datasource to use. */
    private final DataSource dataSource;

    /**
     * Class constructor.
     *
     * @param dataSource the sql dataSource to use for liquibase.
     */
    public LiquibaseUpdater(final DataSource dataSource, boolean run) {
        this.dataSource = dataSource;

        if (run) {
            this.update();
        }
    }

    /**
     * Retrieve a liquibase instance.
     *
     * @return the liquibase instance.
     */
    protected <O> O liquibaseResult(final LiquibaseAction<O> action) {
        try (final Connection c = this.dataSource.getConnection()) {
            final Liquibase liquibase = new Liquibase(DB_CHANGELOG, new ClassLoaderResourceAccessor(), new JdbcConnection(c));
            return action.execute(liquibase);
        } catch (SQLException | LiquibaseException e) {
            throw new RuntimeException("Error during liquibase execution", e);
        }
    }

    /**
     * List all changeSets that hasn't run yet.
     *
     * @return all changeSets that hasn't run.
     */
    public List<String> check() {
        return this.liquibaseResult((liquibase) -> liquibase.listUnrunChangeSets(null, null)
                .stream()
                .map((c) -> "Changelog : '" + c.getId() + "' by " + c.getAuthor() + " in file '" + c.getFilePath() + "'")
                .collect(Collectors.toList()));
    }

    /**
     * Update the database.
     *
     * @return the current instance
     */
    public LiquibaseUpdater update() {
        return this.liquibaseResult((liquibase) -> {
            liquibase.update(new Contexts());
            return this;
        });
    }

    /**
     * Execute a action on liquibase and return the expected output.
     *
     * @param <O> the type of output.
     */
    @FunctionalInterface
    interface LiquibaseAction<O> {

        /**
         * Execute a liquibase action
         *
         * @param liquibase the liquibase instance
         * @return the expected output.
         * @throws LiquibaseException if a error occurred during liquibase execution
         */
        O execute(Liquibase liquibase) throws LiquibaseException;

    }

}

package com.cbp.disponibilite.gestionnaires.database;

import org.postgresql.Driver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * Ne sert pas sauf pour faire des tests.
 *
 */
public class LiquibaseRunner {

	public static void main(String[] args) {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:postgresql://localhost:5439/postgres");
		ds.setDriverClassName(Driver.class.getName());
		ds.setUsername("postgres");
		ds.setPassword("root");

		LiquibaseUpdater liquibaseUpdater = new LiquibaseUpdater(ds, false);

		List<String> listCheck = liquibaseUpdater.check();
		System.out.println("changelog todo: " + listCheck);

		liquibaseUpdater.update();

		listCheck = liquibaseUpdater.check();
		System.out.println("changelog todo: " + listCheck);
	}
}

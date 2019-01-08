package com.cbp.disponibilite.gestionnaires.dao;

import org.apache.commons.lang3.tuple.Pair;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<K, E> {

    @PersistenceContext
    private EntityManager em;

    private Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    /**
     * Récupère dans la source de données l'objet d'identifiant de type K donnée en paramètre.
     *
     * @param id identifiant
     * @return entité E
     */
    protected E findById(final K id) {
        return this.em.find(this.entityClass, id);
    }

    /**
     * Récupère dans la source de données l'objet d'identifiant de type K donnée en paramètre.
     * Throw une erreur si entité non trouvée.
     *
     * @param id identifiant
     * @return entité E
     * @throws EntityNotFoundException si entité non trouvée
     */
    protected E getById(final K id) {
        return Optional.of(em.find(this.entityClass, id))
                .orElseThrow(() -> new EntityNotFoundException("Entity " + this.entityClass.getName() + " with id " + id + " not found"));
    }

    /**
     * Crée la query via l'entity manager
     *
     * @param body corps de la requête
     * @param params paramètres
     * @return javax.persistence.Query
     */
    private TypedQuery<E> query(final String body, final Pair<String, Object>... params) {
        TypedQuery<E> query = this.em.createQuery(body, this.entityClass);
        Arrays.stream(params).forEach(pair -> query.setParameter(pair.getKey(), pair.getValue()));
        return query;
    }


    /**
     * Execute la requête et récupère un seul résultat
     * @param body corps de la requête
     * @param params paramètres
     * @return l'entité trouvé
     */
    @SafeVarargs
    final protected E querySingleResult(final String body, final Pair<String, Object>... params) {
        return query(body, params).getSingleResult();
    }

    /**
     * Execute la requête et récupère une liste de résultat
     * @param body corps de la requête
     * @param params paramètres
     * @return la liste d'entité trouvé
     */
    @SafeVarargs
    final protected List<E> queryResultList(final String body, final Pair<String, Object>... params) {
        return query(body, params).getResultList();
    }

    /**
     * Crée dans la source de données l'objet de type E donné en paramètre.
     *
     * @param entity entité traitée
     * @param flush permet de flush les données ou non
     */
    final protected void persist(final E entity, final boolean flush) {
        this.em.persist(entity);
        flush(flush);
    }

    /**
     * Supprime dans la source de données l'objet de type E donné en paramètre.
     *
     * @param entity entité traitée
     * @param flush permet de flush les données ou non
     */
    final protected void remove(final E entity, final boolean flush) {
        this.em.remove(entity);
        flush(flush);
    }

    /**
     * Met à jour dans la source de données l'objet de type E donné en paramètre.
     *
     * @param entity entité traitée
     * @param flush permet de flush les données ou non
     */
    final protected Object merge(final E entity, final boolean flush) {
        Object objectMerged = this.em.merge(entity);
        flush(flush);
        return objectMerged;
    }

    /**
     * Flush si demandé car on est en auto-commit false dans la conf spring
     *
     * @param flush true/false
     */
    private void flush(final boolean flush) {
        if (flush) {
            this.em.flush();
        }
    }

}

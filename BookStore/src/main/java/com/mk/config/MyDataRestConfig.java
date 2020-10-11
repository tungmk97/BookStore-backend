//package com.mk.config;
//
//import com.mk.entity.Product;
//import com.mk.entity.ProductCategory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//
//import javax.persistence.EntityManager;
//import javax.persistence.metamodel.EntityType;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@Configuration
//public class MyDataRestConfig implements RepositoryRestConfigurer {
//
//    private EntityManager entityManager;
//
//    @Autowired
//    public MyDataRestConfig(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        HttpMethod[] theUnsupportedAction = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
//
//        //disable put post delete
//        config.getExposureConfiguration().forDomainType(Product.class)
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
//
//        config.getExposureConfiguration().forDomainType(ProductCategory.class)
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
//
//        //call an internal helper method
//        exposeIds(config);
//    }
//
//    private void exposeIds(RepositoryRestConfiguration config) {
//        //expose entity ids
//
//        // get a list of all entity classes from the entity manager
//        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
//
//        //create an array of the entity types
//        List<Class> entityClasses  =new ArrayList<>();
//
//        //- get entity type for entities
//        for (EntityType entityType : entities) {
//            entityClasses.add(entityType.getJavaType());
//        }
//
//        //expose the entity ids for the array of entity/domain types
//        Class[] domainType = entityClasses.toArray(new Class[0]);
//        config.exposeIdsFor(domainType);
//    }
//}

#Resolved by changing PersonnelID==1 with a UserRegister()
ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-1) HTTP Request to /users/register failed, error id: f05f2d41-060b-4244-a8eb-6d2e95c915be-1: org.hibernate.PersistentObjectException: detached entity passed to persist: org.camunda.bpm.quarkus.example.model.Personnel
	at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:88)
	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
	at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
	at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
	at io.quarkus.hibernate.orm.runtime.session.TransactionScopedSession.persist(TransactionScopedSession.java:145)
	at org.hibernate.engine.spi.SessionLazyDelegator.persist(SessionLazyDelegator.java:275)
	at org.hibernate.Session_3a974b6a18ac399f675913d732c105426414d370_Synthetic_ClientProxy.persist(Unknown Source)
	at io.quarkus.hibernate.orm.panache.common.runtime.AbstractJpaOperations.persist(AbstractJpaOperations.java:101)
	at io.quarkus.hibernate.orm.panache.common.runtime.AbstractJpaOperations.persist(AbstractJpaOperations.java:96)
	at io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist(PanacheEntityBase.java:53)
	at org.camunda.bpm.quarkus.example.rest.UserResource.register(UserResource.java:23)
	at org.camunda.bpm.quarkus.example.rest.UserResource_Subclass.register$$superforward(Unknown Source)
	at org.camunda.bpm.quarkus.example.rest.UserResource_Subclass$$function$$3.apply(Unknown Source)
	at io.quarkus.arc.impl.AroundInvokeInvocationContext.proceed(AroundInvokeInvocationContext.java:73)
	at io.quarkus.arc.impl.AroundInvokeInvocationContext.proceed(AroundInvokeInvocationContext.java:62)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:136)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:107)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired.doIntercept(TransactionalInterceptorRequired.java:38)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.intercept(TransactionalInterceptorBase.java:61)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired.intercept(TransactionalInterceptorRequired.java:32)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired_Bean.intercept(Unknown Source)
	at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:42)
	at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:30)
	at io.quarkus.arc.impl.InvocationContexts.performAroundInvoke(InvocationContexts.java:27)
	at org.camunda.bpm.quarkus.example.rest.UserResource_Subclass.register(Unknown Source)
	at org.camunda.bpm.quarkus.example.rest.UserResource$quarkusrestinvoker$register_a3f6b613ee489f5ab638a36faa5fb38a66189061.invoke(Unknown Source)
	at org.jboss.resteasy.reactive.server.handlers.InvocationHandler.handle(InvocationHandler.java:29)
	at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:141)



ERROR [org.cam.bpm.eng.context] (Camunda Metrics Reporter) ENGINE-16004 Exception while closing command context: An exception occurred in the persistence layer. Please check the server logs for a detailed message and the entire exception stack trace.: org.camunda.bpm.engine.ProcessEnginePersistenceException: An exception occurred in the persistence layer. Please check the server logs for a detailed message and the entire exception stack trace.
	at org.camunda.bpm.engine.impl.util.ExceptionUtil.wrapPersistenceException(ExceptionUtil.java:357)
	at org.camunda.bpm.engine.impl.db.EnginePersistenceLogger.flushDbOperationUnexpectedException(EnginePersistenceLogger.java:682)
	at org.camunda.bpm.engine.impl.db.entitymanager.DbEntityManager.flushDbOperations(DbEntityManager.java:344)
	at org.camunda.bpm.engine.impl.db.entitymanager.DbEntityManager.flushDbOperationManager(DbEntityManager.java:323)
	at org.camunda.bpm.engine.impl.db.entitymanager.DbEntityManager.flush(DbEntityManager.java:295)
	at org.camunda.bpm.engine.impl.interceptor.CommandContext.flushSessions(CommandContext.java:272)
	at org.camunda.bpm.engine.impl.interceptor.CommandContext.close(CommandContext.java:188)
	at org.camunda.bpm.engine.impl.interceptor.CommandContextInterceptor.execute(CommandContextInterceptor.java:119)
	at org.camunda.bpm.engine.impl.interceptor.AbstractTransactionInterceptor.execute(AbstractTransactionInterceptor.java:54)
	at org.camunda.bpm.engine.impl.interceptor.ProcessApplicationContextInterceptor.execute(ProcessApplicationContextInterceptor.java:70)
	at org.camunda.bpm.engine.impl.interceptor.CommandCounterInterceptor.execute(CommandCounterInterceptor.java:35)
	at org.camunda.bpm.engine.impl.interceptor.LogInterceptor.execute(LogInterceptor.java:33)
	at org.camunda.bpm.engine.impl.interceptor.ExceptionCodeInterceptor.execute(ExceptionCodeInterceptor.java:55)
	at org.camunda.bpm.engine.impl.metrics.reporter.MetricsCollectionTask.collectMetrics(MetricsCollectionTask.java:76)
	at org.camunda.bpm.engine.impl.metrics.reporter.MetricsCollectionTask.run(MetricsCollectionTask.java:53)
	at java.base/java.util.TimerThread.mainLoop(Timer.java:566)
	at java.base/java.util.TimerThread.run(Timer.java:516)
Caused by: org.camunda.bpm.engine.ProcessEngineException: ENGINE-03083 Unexpected exception while executing database operations with message '
### Error updating database.  Cause: java.sql.SQLException: This pool is closed and does not handle any more connections!
### The error may exist in org/camunda/bpm/engine/impl/mapping/entity/Metrics.xml
### The error may involve org.camunda.bpm.engine.impl.persistence.entity.MeterLogEntity.insertMeterLog
### The error occurred while executing an update
### Cause: java.sql.SQLException: This pool is closed and does not handle any more connections!'. Flush summary: 
 [
  INSERT MeterLogEntity[f3334bcf-db17-11ee-9ab3-024266da22ce]
  INSERT MeterLogEntity[f33399f0-db17-11ee-9ab3-024266da22ce]




 WARN  [org.cam.bpm.eng.metrics] (Camunda Metrics Reporter) ENGINE-18001 Could not collect and log metrics: org.camunda.bpm.engine.ProcessEnginePersistenceException: An exception occurred in the persistence layer. Please check the server logs for a detailed message and the entire exception stack trace.
	at org.camunda.bpm.engine.impl.util.ExceptionUtil.wrapPersistenceException(ExceptionUtil.java:357)
	at org.camunda.bpm.engine.impl.db.EnginePersistenceLogger.flushDbOperationUnexpectedException(EnginePersistenceLogger.java:682)
	at org.camunda.bpm.engine.impl.db.entitymanager.DbEntityManager.flushDbOperations(DbEntityManager.java:344)
	at org.camunda.bpm.engine.impl.db.entitymanager.DbEntityManager.flushDbOperationManager(DbEntityManager.java:323)
	at org.camunda.bpm.engine.impl.db.entitymanager.DbEntityManager.flush(DbEntityManager.java:295)
	at org.camunda.bpm.engine.impl.interceptor.CommandContext.flushSessions(CommandContext.java:272)
	at org.camunda.bpm.engine.impl.interceptor.CommandContext.close(CommandContext.java:188)
	at org.camunda.bpm.engine.impl.interceptor.CommandContextInterceptor.execute(CommandContextInterceptor.java:119)
	at org.camunda.bpm.engine.impl.interceptor.AbstractTransactionInterceptor.execute(AbstractTransactionInterceptor.java:54)
	at org.camunda.bpm.engine.impl.interceptor.ProcessApplicationContextInterceptor.execute(ProcessApplicationContextInterceptor.java:70)
	at org.camunda.bpm.engine.impl.interceptor.CommandCounterInterceptor.execute(CommandCounterInterceptor.java:35)
	at org.camunda.bpm.engine.impl.interceptor.LogInterceptor.execute(LogInterceptor.java:33)
	at org.camunda.bpm.engine.impl.interceptor.ExceptionCodeInterceptor.execute(ExceptionCodeInterceptor.java:55)
	at org.camunda.bpm.engine.impl.metrics.reporter.MetricsCollectionTask.collectMetrics(MetricsCollectionTask.java:76)
	at org.camunda.bpm.engine.impl.metrics.reporter.MetricsCollectionTask.run(MetricsCollectionTask.java:53)
	at java.base/java.util.TimerThread.mainLoop(Timer.java:566)
	at java.base/java.util.TimerThread.run(Timer.java:516)
Caused by: org.camunda.bpm.engine.ProcessEngineException: ENGINE-03083 Unexpected exception while executing database operations with message '
### Error updating database.  Cause: java.sql.SQLException: This pool is closed and does not handle any more connections!
### The error may exist in org/camunda/bpm/engine/impl/mapping/entity/Metrics.xml
### The error may involve org.camunda.bpm.engine.impl.persistence.entity.MeterLogEntity.insertMeterLog
### The error occurred while executing an update
### Cause: java.sql.SQLException: This pool is closed and does not handle any more connections!'. Flush summary: 
 [
  INSERT MeterLogEntity[f3334bcf-db17-11ee-9ab3-024266da22ce]
  INSERT MeterLogEntity[f33399f0-db17-11ee-9ab3-024266da22ce]





WARN  [org.hib.eng.jdb.env.int.JdbcEnvironmentInitiator] (JPA Startup Thread) HHH000342: Could not obtain connection to query metadata: java.sql.SQLException: Acquisition timeout while waiting for new connection
	at io.agroal.pool.ConnectionPool.handlerFromSharedCache(ConnectionPool.java:321)
	at io.agroal.pool.ConnectionPool.getConnection(ConnectionPool.java:249)
	at io.agroal.pool.DataSource.getConnection(DataSource.java:86)
	at io.quarkus.hibernate.orm.runtime.customized.QuarkusConnectionProvider.getConnection(QuarkusConnectionProvider.java:23)
	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:316)
	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:152)
	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:34)
	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:119)
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:264)
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:239)
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
	at org.hibernate.engine.jdbc.internal.JdbcServicesImpl.configure(JdbcServicesImpl.java:45)
	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.configureService(StandardServiceRegistryImpl.java:125)
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:248)
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
	at org.hibernate.boot.internal.SessionFactoryOptionsBuilder.<init>(SessionFactoryOptionsBuilder.java:274)
	at io.quarkus.hibernate.orm.runtime.recording.PrevalidatedQuarkusMetadata.buildSessionFactoryOptionsBuilder(PrevalidatedQuarkusMetadata.java:70)
	at io.quarkus.hibernate.orm.runtime.boot.FastBootEntityManagerFactoryBuilder.build(FastBootEntityManagerFactoryBuilder.java:81)
	at io.quarkus.hibernate.orm.runtime.FastBootHibernatePersistenceProvider.createEntityManagerFactory(FastBootHibernatePersistenceProvider.java:74)
	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:80)
	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:55)
	at io.quarkus.hibernate.orm.runtime.JPAConfig$LazyPersistenceUnit.get(JPAConfig.java:156)
	at io.quarkus.hibernate.orm.runtime.JPAConfig$1.run(JPAConfig.java:64)
	at java.base/java.lang.Thread.run(Thread.java:840)
Caused by: java.util.concurrent.TimeoutException
	at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:204)
	at io.agroal.pool.ConnectionPool.handlerFromSharedCache(ConnectionPool.java:298)
	... 23 more


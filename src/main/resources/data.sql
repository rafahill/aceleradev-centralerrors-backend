insert into error (id, hostname, title, details, error_type, environment, archived, created_at)
values (1001, '192.168.1.81', 'RequestCacheAwareFilter', '2019-11-28 21:22:38.700 DEBUG 3 --- [io-23400-exec-6] o.s.security.web.FilterChainProxy : /error at position 6 of 11 in additional filter chain; firing Filter: RequestCacheAwareFilter host:ec2-54-205-40-20.compute-1.amazonaws.com app:app syslog5424_pri:190 pri:<190>', 'WARNING', 'PRODUCTION', 'false', now());

insert into error (id, hostname, title, details, error_type, environment, archived, created_at)
values (1002, '192.168.2.3', 'Internal Server Error', '2019-11-28 21:56:45.499 DEBUG 3 --- [io-23400-exec-3] o.s.w.s.m.m.a.HttpEntityMethodProcessor  : Writing [{timestamp=Thu Nov 28 21:56:45 UTC 2019, status=500, error=Internal Server Error, message=No message available, path=/person/findAll/5d8bcee92947300004a45b2f/YXV0aDB8NWRiYzMxYjg2MDBlODIwZTI2MjA3ZTMw}]', 'DEBUG', 'PRODUCTION', 'false', now());

insert into error (id, hostname, title, details, error_type, environment, archived, created_at)
values (1003, '192.168.3.48', 'FilterSecurityInterceptor', '2019-11-28 21:56:45.498 DEBUG 3 --- [io-23400-exec-3] o.s.security.web.FilterChainProxy        : /error at position 11 of 11 in additional filter chain; firing Filter: FilterSecurityInterceptor', 'ERROR', 'PRODUCTION', 'false', now());

insert into error (id, hostname, title, details, error_type, environment, archived, created_at)
values (1004, '192.168.3.158', 'Request processing failed', '2019-11-28 21:22:38.697 ERROR --- 3 threw exception [Request processing failed; nested exception is java.lang.NullPointerException] with root cause host:ec2-54-205-40-20.compute-1.amazonaws.com', 'ERROR', 'HOMOLOGATION', 'false', now());

insert into error (id, hostname, title, details, error_type, environment, archived, created_at)
values (1005, '192.168.3.157', 'AntPathRequestMatcher', '2019-11-28 20:56:39.257 DEBUG 3 --- [io-23400-exec-6] o.s.s.w.u.matcher.AntPathRequestMatcher : Request GET /error doesnt match DELETE /logout', 'ERROR', 'DEVELOPMENT', 'false', now());

--insert into errors (id, hostname, title, details, errorType, environment, created_at)
--values (1004, '192.168.3.77', 'AntPathRequestMatcher', '2019-11-28 20:56:39.257 DEBUG 3 --- [io-23400-exec-6] o.s.s.w.u.matcher.AntPathRequestMatcher : Request GET /error doesnt match DELETE /logout', 'ERROR', 'DEVELOPMENT', now());



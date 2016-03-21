// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = [
    'Gecko',
    'WebKit',
    'Presto',
    'Trident'
]
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          [
        'text/html',
        'application/xhtml+xml'
    ],
    js:            'text/javascript',
    json:          [
        'application/json',
        'text/json'
    ],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           [
        'application/hal+json',
        'application/hal+xml'
    ],
    xml:           [
        'text/xml',
        'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = [
    '/images/*',
    '/css/*',
    '/js/*',
    '/plugins/*'
]

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}

grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
        //	grails.plugin.springsecurity.debug.useFilter = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.codehaus.groovy.grails.plugin',            // plugins
            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
    debug 	'com.hantsylabs',
            'org.springframework.security',
            'grails.plugin.springsecurity'
}

//Grails Cache config.
grails.cache.enabled=true
//grails.cache.proxyTargetClass	false
//grails.cache.aopOrder	Ordered.LOWEST_PRECEDENCE
//grails.cache.clearAtStartup	false
//grails.cache.keyGenerator	"customCacheKeyGenerator"
grails.cache.config = {
    cache {  name 'xauth-token'  }
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.hantsylabs.grails.example.security.Person'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.hantsylabs.grails.example.security.PersonAuthority'
grails.plugin.springsecurity.authority.className = 'com.hantsylabs.grails.example.security.Authority'
grails.plugin.springsecurity.requestMap.className = 'com.hantsylabs.grails.example.security.Requestmap'
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
    '/':                              ['permitAll'],
    '/index':                         ['permitAll'],
    '/index.gsp':                     ['permitAll'],
    '/**/js/**':                      ['permitAll'],
    '/**/css/**':                     ['permitAll'],
    '/**/images/**':                  ['permitAll'],
    '/**/favicon.ico':                ['permitAll']]
grails.plugin.springsecurity.interceptUrlMap = [
    '/app/**':             ['permitAll'],
    '/**/js/**':          ['permitAll'],
    '/**/css/**':         ['permitAll'],
    '/**/images/**':      ['permitAll'],
    '/**/favicon.ico':    ['permitAll'],
    '/api/login':          ['permitAll'],
    '/api/validate':         ['permitAll'],
    '/api/status':          ['permitAll'],
    '/**':				  ['isFullyAuthenticated()']]

//grails.plugin.springsecurity.useBasicAuth = true
//grails.plugin.springsecurity.basic.realmName = "Ralph's Bait and Tackle"

//cors config.
cors.enabled=true
cors.url.pattern = '/api/*'
cors.headers=[
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Credentials': true,
    'Access-Control-Allow-Headers': 'origin, authorization, accept, content-type, x-requested-with',
    'Access-Control-Allow-Methods': 'GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS',
    'Access-Control-Max-Age': 3600
    ]
//Config for Spring Security REST plugin

//login
grails.plugin.springsecurity.rest.login.active=true
grails.plugin.springsecurity.rest.login.endpointUrl="/api/login"
grails.plugin.springsecurity.rest.login.failureStatusCode=401
grails.plugin.springsecurity.rest.login.useJsonCredentials=true
grails.plugin.springsecurity.rest.login.usernamePropertyName='username'
grails.plugin.springsecurity.rest.login.passwordPropertyName='password'

//logout
grails.plugin.springsecurity.rest.logout.endpointUrl='/api/logout'


//token generation
grails.plugin.springsecurity.rest.token.generation.useSecureRandom=true
grails.plugin.springsecurity.rest.token.generation.useUUID=false

//token storage
// use memcached.
//grails.plugin.springsecurity.rest.token.storage.useMemcached	false
//grails.plugin.springsecurity.rest.token.storage.memcached.hosts	localhost:11211
//grails.plugin.springsecurity.rest.token.storage.memcached.username	''
//grails.plugin.springsecurity.rest.token.storage.memcached.password	''
//grails.plugin.springsecurity.rest.token.storage.memcached.expiration	3600

//use GROM
//grails.plugin.springsecurity.rest.token.storage.useGorm	false
//grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName	null
//grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName	tokenValue
//grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName	username
//class AuthenticationToken {
//
//	String tokenValue
//	String username
//}

//use cache as storage
grails.plugin.springsecurity.rest.token.storage.useGrailsCache=true
grails.plugin.springsecurity.rest.token.storage.grailsCacheName='xauth-token'

//token rendering
grails.plugin.springsecurity.rest.token.rendering.usernamePropertyName='username'
grails.plugin.springsecurity.rest.token.rendering.authoritiesPropertyName='roles'
grails.plugin.springsecurity.rest.token.rendering.tokenPropertyName='token'


//token validate
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true

//if disable 'Bearer', you can configure a custom header.
//grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
//grails.plugin.springsecurity.rest.token.rendering.tokenPropertyName   access_token
//grails.plugin.springsecurity.rest.token.validation.headerName = 'x-auth-token'
grails.plugin.springsecurity.rest.token.validation.active=true
grails.plugin.springsecurity.rest.token.validation.endpointUrl='/api/validate'

grails{
    plugin{
        springsecurity{
            filterChain{
                chainMap = [
                    '/api/guest/**': 'anonymousAuthenticationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor',
                    '/api/**': 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter',  // Stateless chain
                    '/**': 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'                                          // Traditional chain

                    //	'/api/**':'JOINED_FILTERS,-exceptionTranslationFilter',
                    //	'/api/**': 'statelessSecurityContextPersistenceFilter,logoutFilter,authenticationProcessingFilter,customBasicAuthenticationFilter,securityContextHolderAwareRequestFilter,rememberMeAuthenticationFilter,anonymousAuthenticationFilter,basicExceptionTranslationFilter,filterInvocationInterceptor',
                    //	'/**': 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter'
                ]
            }
            rest {
                token { validation { enableAnonymousAccess = true } }
            }
        }
    }
}
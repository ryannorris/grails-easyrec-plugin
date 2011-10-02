package grails.plugin.easyrec

import groovyx.net.http.HTTPBuilder;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.springframework.beans.factory.InitializingBean
import groovyx.net.http.HttpResponseException

class EasyRecService implements InitializingBean {

	static transactional = false

    String apiKey
    String tenantId
    String url
    String context

	def view(String userId, String sessionId, String itemId, String itemDescription, String itemUrl, String itemImageUrl = null, String actionTime = null) {
        try {
            def http = new HTTPBuilder(url)
            def response = http.get(path: getPath('/api/1.0/view'),
                    query: [apikey: apiKey, tenantid: tenantId, userid: userId,
                            sessionid: sessionId, itemid: itemId, itemdescription: itemDescription, itemurl: itemUrl, itemimageurl: itemImageUrl])

            return response
        } catch (ConnectException e) {
            log.error("Can't connect to EasyRec server. By url: $url / $context. Message: $e.message")
        } catch (HttpResponseException e) {
            log.error("Not found. By url: $url / $context. Message: $e.message")
        }
        return null
	}

	def recomendationsForUser(String userId) {
        try {
            def http = new HTTPBuilder(url)
            def response = http.get(path: getPath('/api/1.0/recommendationsforuser'),
                    query: [apikey: apiKey, tenantid: tenantId, userid: userId])
            return response
        } catch (ConnectException e) {
            log.error("Can't connect to EasyRec server. By url: $url / $context", e)
            return null
        } catch (HttpResponseException e) {
            log.error("Not found. By url: $url / $context", e)
            return null
        }
	}

    String getPath(String path) {
        StringBuilder buf =  new StringBuilder()
        if (context && context.length() > 0) {
            buf.append('/')
            buf.append(context)
        }
        buf.append(path)
        return buf
    }

    void afterPropertiesSet() {
        def conf = CH.config.easyrec
        apiKey = conf.key
        tenantId = conf.tenantId
        url = conf.url
        context = conf.containsKey('urlContext') ? conf.urlContext : null
    }
}

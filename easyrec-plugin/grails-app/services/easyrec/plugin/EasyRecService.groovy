package easyrec.plugin

import groovyx.net.http.HTTPBuilder;
class EasyRecService {

	static transactional = true

	def view(String userId, String sessionId, String itemId, String itemDescription, String itemUrl, String itemImageUrl = null, String actionTime = null) {
		String apiKey = '3532665f1995cc509449d9a8f0600660'
		String tenantId = 'SWAPFISH'

		def http = new HTTPBuilder('http://intralife.researchstudio.at:8080')

		def response = http.get(path: '/api/1.0/view', query: [apikey: apiKey, tenantid: tenantId, userid: userId, sessionid: sessionId, itemid: itemId, itemdescription: itemDescription, itemurl: itemUrl, itemimageurl: itemImageUrl])

		return response
	}

	def recomendationsForUser(String userId) {
		String apiKey = '3532665f1995cc509449d9a8f0600660'
		String tenantId = 'SWAPFISH'

		def http = new HTTPBuilder('http://intralife.researchstudio.at:8080')

		def response = http.get(path: '/api/1.0/recommendationsforuser', query: [apikey: apiKey, tenantid: tenantId, userid: userId])

		return response
	}
}

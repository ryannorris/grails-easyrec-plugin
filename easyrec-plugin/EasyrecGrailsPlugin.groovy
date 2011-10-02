class EasyrecGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Ryan Norris"
    def authorEmail = "ryannorris@gmail.com"
    def title = "Easyrec Plugin"
    def description = '''\\
Provides services for talking with the EasyRec recommendation engine.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/easyrec"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
		/*application.domainClasses.each { domainClass ->
			println "Inspecting ${domainClass.name} for EasyRec support"
			
			def recClosure
			
			if((recClosure = domainClass.getPropertyValue('reccomended'))) {
				
				println "Found ${domainClass.name} to be eligible for EasyRec"
				
				def view = { Object[] args ->
					println this.class.name
					println args
					println "view item ${id}"
					recClosure.delegate = this.delegate
					recClosure.call()
				}
				
				domainClass.metaClass.view << view
				
				println "decorated domain object"
			}
		}*/
    }
	
	def invokeMethod(String methodName, Object args) {
		println methodName
		println args
	}

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}

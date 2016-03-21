class UrlMappings {

	static mappings = {
		
		"/api/status"(controller:"status", action:"index", method:"GET")
		"/api/assets"(resources:"techAidAsset")
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}

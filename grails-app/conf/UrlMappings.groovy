class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
//        "/"(redirect: "/produto/index")
        "500"(view:'/error')
	}
}

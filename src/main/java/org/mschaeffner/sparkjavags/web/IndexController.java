package org.mschaeffner.sparkjavags.web;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

public class IndexController {

	public IndexController() {

		Spark.get("/", (request, response) -> {

			Map<String, Object> model = new HashMap<>();
			return new ModelAndView(model, "index.mustache");

		}, new MustacheTemplateEngine());

	}

}

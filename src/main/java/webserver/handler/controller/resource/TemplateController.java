package webserver.handler.controller.resource;

import webserver.handler.controller.AbstractController;
import webserver.http.HttpStatus;
import webserver.http.request.HttpRequest;
import webserver.http.response.HttpResponse;
import webserver.view.ViewResolver;

public class TemplateController extends AbstractController {
    private static final String TEMPLATE_MAPPING_ENDING_PATH = ".html";

    public TemplateController(ViewResolver viewResolver) {
        super(viewResolver);
    }

    @Override
    protected void doGet(HttpRequest request, HttpResponse response) throws Exception {
        response.send(viewResolver.resolve(request.getPath()), HttpStatus.OK);
    }

    @Override
    public boolean isMapping(HttpRequest request) {
        return request.getPath().endsWith(TEMPLATE_MAPPING_ENDING_PATH);
    }

    @Override
    protected String getRequestedMapping() {
        return TEMPLATE_MAPPING_ENDING_PATH;
    }
}

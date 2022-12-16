package com.vmware.scg.extensions.filter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class AddMyCustomHeaderGatewayFilterFactory
		extends AbstractGatewayFilterFactory<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddMyCustomHeaderGatewayFilterFactory.class);

	private static final String MY_HEADER_KEY = "Demo-Tanzu-Colella";

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) ->
		{
			ServerWebExchange updatedExchange
					= exchange.mutate()
							  .request(request -> {
								  request.headers(headers -> {
									  headers.put(MY_HEADER_KEY, List.of("DEMO SCG"));
									  LOGGER.info("Processed request, added" + MY_HEADER_KEY + " header");
								  });
							  })
							  .build();
			return chain.filter(updatedExchange);
		};
	}
}

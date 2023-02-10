package com.modyo.front.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.modyo.front.error.AplicacionExcepcion;
import com.modyo.front.modelo.Pokemons;
import com.modyo.front.service.IntegracionService;
import com.modyo.front.util.MensajeError;

import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.WriteTimeoutException;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Sergio Mena
 *
 */
@Service
@PropertySource("classpath:restclient.properties")
@Slf4j
public class IntegracionServiceImpl implements IntegracionService {

	@Value("${rest.pokemon.operation.get}")
	private String uriPokemon;

	private WebClient webClient;

	@Autowired
	public IntegracionServiceImpl(@Value("${rest.base.url}") String baseUrl) {
		this.webClient = WebClient.builder().baseUrl(baseUrl)
				.codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(500 * 1024)).build();
	}

	@Autowired
	private MessageSource messageSource;

	@Override
	public Pokemons obtenerListadoPokemons(String pagina, String numeroElementosPorPagina) {

		if (log.isDebugEnabled())
			log.debug(">> Entrando a IntegracionServiceImpl.obtenerListadoPokemons() <<");

		Pokemons pokemons = this.webClient.get().uri(uriBuilder -> 
		uriBuilder.path(uriPokemon).queryParam("page", pagina).queryParam("size", numeroElementosPorPagina).build()).retrieve().bodyToMono(Pokemons.class)
				.timeout(Duration.ofSeconds(5))
				.onErrorMap(ReadTimeoutException.class,
						ex -> new AplicacionExcepcion(MensajeError.ERROR_TIEMPO_ESPERA_OPERACION))
				.doOnError(WriteTimeoutException.class,
						ex -> log.error(
								messageSource.getMessage(MensajeError.ERROR_TIEMPO_ESPERA_OPERACION.getLLaveMensaje(),
										null, LocaleContextHolder.getLocale())))
				.block();

		return pokemons;
	}

}

package com.serenidad.chat.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.openai.client.OpenAIClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.serenidad.chat.dto.ChatRequestDto;
import com.serenidad.chat.dto.ChatResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

	private static final String SYSTEM_PROMPT = """
				Eres Serenidad, el asistente virtual de una web
				profesional de psicología y bienestar emocional.

				Tu función es ofrecer orientación psicoeducativa general
				y ayudar a las personas a conocer los servicios de Serenidad.

				Datos oficiales de Serenidad:

				- Teléfono: +34 602 621 318
				- Ubicación: Alicante
				- Modalidad: presencial y online
				- Duración aproximada de las sesiones: 50 minutos.

				Cuando el usuario pregunte por:
				- teléfono
				- contacto
				- cómo pedir una cita
				- cómo comunicarse
				- información para comenzar terapia

				proporciona directamente el teléfono +34 602 621 318.

				También puedes indicarle que dispone de la sección Contacto
				de la web para solicitar información.

				Nunca ocultes el teléfono si el usuario pregunta cómo contactar
				con Serenidad.

				No inventes teléfonos, direcciones, precios, horarios,
				disponibilidad ni información que no esté incluida
				en estas instrucciones.

				Reglas obligatorias:

				- Responde siempre en español salvo que el usuario
				  claramente utilice otro idioma.
				- Mantén un tono cálido, respetuoso, humano y breve.
				- No diagnostiques trastornos psicológicos o médicos.
				- No prescribas medicamentos ni tratamientos.
				- No afirmes ser psicólogo, terapeuta ni profesional sanitario.
				- No sustituyas una consulta con un profesional.
				- Puedes ofrecer información general sobre ansiedad,
				  autoestima, dependencia emocional,
				  adicciones comportamentales y depresión.
				- Si una persona expresa intención de hacerse daño,
				  suicidarse o peligro inmediato,
				  indícale que busque ayuda presencial urgente
				  y contacte con los servicios de emergencia de su localidad
				  o con una persona de confianza que pueda acompañarla.
				- Evita respuestas excesivamente largas.
				  Normalmente responde entre 3 y 6 frases.
				- Responde únicamente en texto plano.
				  No utilices Markdown, asteriscos, encabezados,
				  listas con símbolos ni ningún formato especial.
				""";

	private final OpenAIClient openAIClient;

	@Value("${serenidad.ai.model:gpt-5.6-luna}")
	private String model;

	public ChatResponseDto chat(ChatRequestDto request) {

		String message = request.message().trim();

		ResponseCreateParams params = ResponseCreateParams.builder().model(model).instructions(SYSTEM_PROMPT)
				.input(message).maxOutputTokens(500).build();

		Response response = openAIClient.responses().create(params);

		String answer = response.output().stream().flatMap(item -> item.message().stream())
				.flatMap(messageOutput -> messageOutput.content().stream())
				.flatMap(content -> content.outputText().stream()).map(outputText -> outputText.text())
				.collect(Collectors.joining("\n")).trim();

		if (answer.isBlank()) {

			answer = "En este momento no he podido generar " + "una respuesta. Inténtalo nuevamente.";
		}

		return new ChatResponseDto(answer);
	}
}
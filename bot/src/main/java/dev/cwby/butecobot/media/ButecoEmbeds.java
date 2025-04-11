package dev.cwby.butecobot.media;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

/**
 * ButecoEmbeds
 */
public class ButecoEmbeds {

	private ButecoEmbeds() {}

	public static final MessageEmbed COOLDOWN_EXTRACT = new EmbedBuilder().setTitle("Suas coins")
			.setDescription("Não vai brotar dinheiro do nada! Aguarde 1 min para ver seu extrato!")
			.setColor(Color.RED)
			.setThumbnail(ButecoMedia.STEVE_NO).build();

	public static final MessageEmbed STARTER_COINS = new EmbedBuilder().setTitle("Bem vindo")
			.setDescription("Você recebeu **100** coins iniciais! Aposte sabiamente :man_mage:")
			.setColor(0xF5D920)
			.setThumbnail(ButecoMedia.ONE_COIN).build();

}

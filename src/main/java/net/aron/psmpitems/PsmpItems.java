package net.aron.psmpitems;

import net.aron.psmpitems.Item.ModItemGroups;
import net.aron.psmpitems.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PsmpItems implements ModInitializer {
	public static final String MOD_ID = "psmpitems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier BONK_SOUND_ID = new Identifier(MOD_ID, "bonk_sound");
	public static final SoundEvent BONK_SOUND_EVENT = SoundEvent.of(BONK_SOUND_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		registerSounds();
	}

	private void registerSounds() {
		Registry.register(Registries.SOUND_EVENT, BONK_SOUND_ID, BONK_SOUND_EVENT);
		LOGGER.info("Registered Bonk Sound Event");
	}
}

package net.aron.psmpitems;

import net.aron.psmpitems.Item.ModItemGroups;
import net.aron.psmpitems.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PsmpItems implements ModInitializer {
	public static final String MOD_ID = "psmpitems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}
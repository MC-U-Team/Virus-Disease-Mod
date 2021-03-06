package info.u_team.virus_disease_spread.data.provider;

import info.u_team.u_team_core.data.CommonLanguagesProvider;
import info.u_team.u_team_core.data.GenerationData;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadEffects;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadItemGroups;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadItems;

public class VirusDiseaseSpreadLanguagesProvider extends CommonLanguagesProvider {
	
	public VirusDiseaseSpreadLanguagesProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	public void addTranslations() {
		// English
		addEffect(VirusDiseaseSpreadEffects.INFECTED, "Infected");
		
		add("item.minecraft.potion.effect.infected", "Potion of Viruses");
		add("item.minecraft.splash_potion.effect.infected", "Splash Potion of Viruses");
		add("item.minecraft.lingering_potion.effect.infected", "Lingering Potion of Viruses");
		add("item.minecraft.tipped_arrowt.effect.infected", "Arrow of Viruses");
		
		add("event.virusdiseasespread.infection_prob_message", "Infection probablility is now %s");
		add("event.virusdiseasespread.washing_message", "Washing: %s");
		
		add(VirusDiseaseSpreadItemGroups.GROUP, "Virus Disease Spread");
		
		addItem(VirusDiseaseSpreadItems.PROBABILITY_TEST, "Probability Test");
		
		// German
		
		addEffect("de_de", VirusDiseaseSpreadEffects.INFECTED, "Infiziert");
		
		add("de_de", "item.minecraft.potion.effect.infected", "Trank des Viruses");
		add("de_de", "item.minecraft.splash_potion.effect.infected", "Wurftrank des Viruses");
		add("de_de", "item.minecraft.lingering_potion.effect.infected", "Verweiltrank des Viruses");
		add("de_de", "item.minecraft.tipped_arrowt.effect.infected", "Pfeil des Viruses");
		
		add("de_de", "event.virusdiseasespread.infection_prob_message", "Infektionswahrscheinlichkeit ist nun %s");
		add("de_de", "event.virusdiseasespread.washing_message", "Waschen: %s");
		
		add("de_de", VirusDiseaseSpreadItemGroups.GROUP, "Verbreitung von Viruserkrankungen");
		
		addItem("de_de", VirusDiseaseSpreadItems.PROBABILITY_TEST, "Wahrscheinlichkeitstest");
	}
	
}

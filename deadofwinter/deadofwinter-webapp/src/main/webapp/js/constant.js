const DESCRIPTION_TYPE = {
	VICTORY: "<%=DescriptionType.VICTORY%>",
	ADDITIONAL_RULE: "<%=DescriptionType.ADDITIONAL_RULE%>",
	DIFFICULTY_RULE: "<%=DescriptionType.DIFFICULTY_RULE%>"
}

const DIFFICULTY_LEVEL = {
		NORMAL:  "<%=DifficultyLevel.NORMAL%>",
		HARD:    "<%=DifficultyLevel.HARD%>",
		EXTREME: "<%=DifficultyLevel.EXTREME%>"
	}

const REPLACING_NUMBERS_SEPARATION = ",";

const REPLACED_LEFT_MARK = "{";
const REPLACED_RIGHT_MARK = "}";

const BASE_DIR = '/deadofwinter/';

const IMAGE_REPLACE_JUNK = {
		text: REPLACED_LEFT_MARK + "J" + REPLACED_RIGHT_MARK,
		url: BASE_DIR + "/images/card_type/junk.png"
};

const IMAGE_REPLACE_FOOD = {
		text: REPLACED_LEFT_MARK + "F" + REPLACED_RIGHT_MARK,
		url: BASE_DIR + "/images/card_type/food.png"
};

const IMAGE_REPLACE_FUEL = {
		text: REPLACED_LEFT_MARK + "FU" + REPLACED_RIGHT_MARK,
		url: BASE_DIR + "/images/card_type/fuel.png"
};

const IMAGE_REPLACE_MEDICINE = {
		text: REPLACED_LEFT_MARK + "M" + REPLACED_RIGHT_MARK,
		url: BASE_DIR + "/images/card_type/medicine.png"
};

const IMAGES_REPLACE = {IMAGE_REPLACE_JUNK, IMAGE_REPLACE_FOOD, IMAGE_REPLACE_FUEL, IMAGE_REPLACE_MEDICINE};

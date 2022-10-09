package chapter3;

public class StandardCardConfigurator implements CardConfigurator { // The same as using the default constructor.
	public boolean isValid(Card pCard) {
		return true;
	}
}

class AllBlacksConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return pCard.isBlack();
	}
}

class AllRedsConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return pCard.isRed();
	}
}

class AllFacesConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return pCard.isFace();
	}
}

class AllNumbersConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return pCard.isNumber();
	}
}

class BlackFacesConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return (pCard.isBlack() && pCard.isFace());
	}
}

class BlackNumbersConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return (pCard.isBlack() && pCard.isNumber());
	}
}

class RedFacesConfigurator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return (pCard.isRed() && pCard.isFace());
	}
}

class RedNumbersConfigurationValidator implements CardConfigurator {
	public boolean isValid(Card pCard) {
		return (pCard.isRed() && pCard.isNumber());
	}
}

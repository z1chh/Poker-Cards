package practice;

public interface CardValidator {
	public boolean isValid(Card pCard);
}

class DefaultValidator implements CardValidator {

	@Override
	public boolean isValid(Card pCard) {
		return true;
	}
	
}

class NullValidator implements CardValidator {

	@Override
	public boolean isValid(Card pCard) {
		return false;
	}
	
}

class BlackOnlyValidator implements CardValidator {

	@Override
	public boolean isValid(Card pCard) {
		return pCard.isBlack();
	}
	
}

class RedOnlyValidator implements CardValidator {

	@Override
	public boolean isValid(Card pCard) {
		return pCard.isRed();
	}
	
}

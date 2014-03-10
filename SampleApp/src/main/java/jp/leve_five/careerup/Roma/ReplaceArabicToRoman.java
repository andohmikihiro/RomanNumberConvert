package jp.leve_five.careerup.Roma;

public class ReplaceArabicToRoman {
	// �����̕���������[�}�����ɕϊ�
	public String changeNumberToRoman(int numberInt)
			throws RuntimeException {
		// ���͒l��4000�����������͂P�ȏ�ł��邩����
		if (numberInt >= 4000 || 0 >= numberInt) {
			throw new RuntimeException("�ϊ��͈͊O�ł�");
		}
		String numberString = String.valueOf(numberInt);

		byte stringBytes[] = numberString.getBytes();
		StringBuffer roman = new StringBuffer();
		int numberDigit = stringBytes.length;
		int byteDigit = 0;
		// ���[�}������2�����z��@�z��̃C���f�b�N�X�ɍ��킹�āA�P�`�X�A�P�O�`�X�O�A�P�O�O�`�X�O�O�C�P�O�O�O�`�S�O�O�O�܂�
		String romanTable[][] = {
				{ "", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", },
				{ "", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc", },
				{ "", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm", },
				{ "", "m", "mm", "mmm", "mmmm", "", "", "", "", "", } };

		// StringBuffer roman�ɓ��͒l�̌��ɕ������ǉ�����switch��
		addRoman(stringBytes, roman, numberDigit, byteDigit, romanTable);
		return roman.toString().toUpperCase();
	}

	private void addRoman(byte[] stringBytes, StringBuffer roman,
			int numberDigit, int byteDigit, String[][] romanTable) {
		switch (numberDigit) {
		default:
			throw new RuntimeException("�����Ȑ��l�ł�");
		case 4: 
			roman.append(romanTable[3][(stringBytes[byteDigit] - '0')]);
			byteDigit++;
		case 3: 
			roman.append(romanTable[2][(stringBytes[byteDigit] - '0')]);
			byteDigit++;
		case 2: 
			roman.append(romanTable[1][(stringBytes[byteDigit] - '0')]);
			byteDigit++;
		case 1:
			roman.append(romanTable[0][(stringBytes[byteDigit] - '0')]);
		}
	}

}
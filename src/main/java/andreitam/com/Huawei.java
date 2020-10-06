package andreitam.com;

/**
 * Abstract class inherits AbstractPhone.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-06
 */
abstract class Huawei extends AbstractPhone {

    Huawei(Integer battery_life, Color color, Material material) {
        super(battery_life, color, material, createImei());
    }

    private static String createImei() {
        // define the range
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        String imei = "";
        // generate random numbers within 1 to 10 and concatenate in 16 characters
        for (int i = 0; i < 16; i++) {
            int rand = (int)(Math.random() * range) + min;
            imei = imei + rand;
        }
        return imei;
    }
}

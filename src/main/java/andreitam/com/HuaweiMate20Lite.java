package andreitam.com;
/**
 * Class SamsungGalaxyS6 inherits Samsung.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public class HuaweiMate20Lite extends Huawei {
    //default constructor with BLACK color
    HuaweiMate20Lite() {
        super(30, Color.WHITE, Material.GLASS);
    }
    //constructor overloaded so clinet can specify color
    HuaweiMate20Lite(Color color) {
        super(30, color, Material.GLASS);
    }
}

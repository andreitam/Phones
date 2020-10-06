package andreitam.com;
/**
 * Class SamsungGalaxyS6 inherits Samsung.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public class HuaweiMateP30Pro extends Huawei {
    //default constructor with BLACK color
    HuaweiMateP30Pro() {
        super(72, Color.PINK, Material.GLASS);
    }
    //constructor overloaded so clinet can specify color
    HuaweiMateP30Pro(Color color) {
        super(72, color, Material.GLASS);
    }
}

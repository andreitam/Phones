package andreitam.com;
/**
 * Class SamsungGalaxyS6 inherits Samsung.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public class SamsungGalaxyS6 extends Samsung {
    //default constructor with BLACK color
    SamsungGalaxyS6() {
        super(48, Color.BLACK, Material.ALUMINIUM);
    }
    //constructor overloaded so clinet can specify color
    SamsungGalaxyS6(Color color) {
        super(48, color, Material.ALUMINIUM);
    }
}

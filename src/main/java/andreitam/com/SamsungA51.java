package andreitam.com;
/**
 * Class SamsungGalaxyS6 inherits Samsung.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-04
 */
public class SamsungA51 extends Samsung {
    //default constructor with BLACK color
    SamsungA51() {
        super(36, Color.LIGHT_BLUE, Material.ALUMINIUM);
    }
    //constructor overloaded so clinet can specify color
    SamsungA51(Color color) {
        super(36, color, Material.ALUMINIUM);
    }
}

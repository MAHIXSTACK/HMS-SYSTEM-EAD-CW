/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagement;

/**
 *
 * @author Mahima
 */
public class ComboBoxItem {
    private final int id;
    private final String name;

    /**
     *
     * @param id
     * @param name
     */
    public ComboBoxItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // This method is crucial. It determines what text is shown in the combo box.
    @Override
    public String toString() {
        return name;
}

}

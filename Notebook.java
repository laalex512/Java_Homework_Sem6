import java.util.HashMap;
import java.util.Map;

public class Notebook {
    private Map<String, String> parametres = new HashMap<>();

    public Notebook(String name, String ram, String hdd, String os, String display, String color) {
        this.parametres.put("name", name);
        this.parametres.put("ram", ram);
        this.parametres.put("hdd", hdd);
        this.parametres.put("os", os);
        this.parametres.put("display", display);
        this.parametres.put("color", color);
    }

    @Override
    public String toString() {
        String notebook = "";
        for (String i : this.parametres.keySet()) {
            notebook += i + ": " + this.parametres.get(i) + "; ";
        }
        notebook += "\n";
        return notebook;
    }

    public String getParameter(String parameter) {
        return this.parametres.get(parameter);
    }

    @Override
    public boolean equals(Object someNoteObject) {
        Notebook someNote = (Notebook) someNoteObject;
        return (this.parametres.get("name").equals(someNote.parametres.get("name"))) &&
                (this.parametres.get("ram").equals(someNote.parametres.get("ram"))) &&
                (this.parametres.get("hdd").equals(someNote.parametres.get("hdd"))) &&
                (this.parametres.get("os").equals(someNote.parametres.get("os"))) &&
                (this.parametres.get("display").equals(someNote.parametres.get("display")) &&
                        (this.parametres.get("color").equals(someNote.parametres.get("color"))));
    }

    @Override
    public int hashCode() {
        return (Integer.parseInt(this.parametres.get("ram"))
                + Integer.parseInt(this.parametres.get("hdd"))
                + Integer.parseInt(this.parametres.get("display"))) * 27;
    }
}

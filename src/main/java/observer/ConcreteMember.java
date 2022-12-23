package observer;

public class ConcreteMember implements Member {
    private String name;
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    public ConcreteMember(){
        this.name = null;
        this.usb = null;

    }

    public ConcreteMember (UndoableStringBuilder usb, String name)  {
        this.usb = usb;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    /**
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    public UndoableStringBuilder getStringBuilder(){
        return this.usb;
    }

}

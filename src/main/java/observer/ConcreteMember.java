package observer;

public class ConcreteMember implements Member {
    private String name;
    // the message that every member gets from the group admin.
    //is in undoStringBuilder format.
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    /**
     * a constructor that gets a name and sets it to the member.
     * and undostringbuilder to have the ability to get messages from the group admin.
     */
    public ConcreteMember(){
        this.name = null;
        this.usb = null;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    /**
     * @param usb we do a sallow copy on the undoStringBuilders of all
     *            the members in the group admin array list.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    public UndoableStringBuilder getStringBuilder(){
        return this.usb;
    }

}

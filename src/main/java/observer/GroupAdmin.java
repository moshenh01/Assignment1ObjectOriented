package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {

    private List<Member> subs = new ArrayList<>();
    private int last =0;
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    /**
     * @param obj
     */
    @Override
    public void register(Member obj) {
        subs.add(obj); last++;
    }

    /**
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
        subs.remove(obj);last--;
    }

    /**
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset,obj);
    }

    /**
     * @param obj
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
    }

    /**
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start,end);
    }

    /**
     *
     */
    @Override
    public void undo() {
        this.usb.undo();

    }
    public void notifyMembers() {
        for (Member m : subs)
            m.update(this.usb);
    }
    public Member getLastMember(){
        if(this.subs.isEmpty()){
            return null;
        }
        return this.subs.get(last - 1);
    }
    public UndoableStringBuilder getStringBuilder(){
        return this.usb;
    }

}

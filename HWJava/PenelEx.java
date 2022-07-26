import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Color;
class PanelEx extends Frame{
    Button btn[] = { new Button("버튼01"),
    new Button("버튼02"),
    new Button("버튼03"),
    new Button("버튼04"),
    new Button("버튼05"),
    new Button("버튼06")};

    Button btn2[] = { new Button("버튼01"),
    new Button("버튼02"),
    new Button("버튼03"),
    new Button("버튼04"),
    new Button("버튼05"),
    new Button("버튼06")};
    public static void main(String[] args) {
        PanelEx obj = new PanelEx();
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        obj.setLayout(new BorderLayout());
        obj.add(BorderLayout.NORTH,p1);
        obj.add(BorderLayout.SOUTH,p2);
        
        p1.setLayout(new FlowLayout());
        for (int i =0 ; i<obj.btn.length ; i++){
            p1.add(obj.btn[i]);
        }
        p2.setLayout(new FlowLayout());
        for (int i =0 ; i<obj.btn.length ; i++){
            p2.add(obj.btn2[i]);
        }
        p1.setBackground(Color.darkGray);
        p2.setBackground(Color.darkGray);
        obj.setTitle("PanelEx");
	    obj.setSize(1200,700);
	    obj.setVisible(true);
    }
}
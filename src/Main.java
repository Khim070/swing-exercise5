import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main implements ActionListener {
    JFrame frame = new JFrame("Username Login");
    JLabel lSignUp, lUsername1, lPassword1, lRePassword, lLogIn, lUsername2, lPassword2, lCorrect, lInCorrect, lAttempts, lYourAttempts;
    JTextField txtUsername1, txtUsername2;
    JPasswordField txtPassword1, txtRePassword, txtPassword2;
    JButton btnSignUp, btnClear1, btnLogIn, btnClear2;
    CardLayout cl;
    JPanel pMain, pSignUp, pSignUpCenter, pLogIn, pLogInCenter, pCorrect, pIncorrect;

    int attemps = 3;

    String varUsername;
    String varPassword;

    public static void main(String[] args) {
        new Main().Login();
    }

    public void Login(){
        cl = new CardLayout();

        pMain = new JPanel();
        pMain.setLayout(cl);

        pSignUp = new JPanel(new BorderLayout(10,10));
        pSignUpCenter = new JPanel(new GridLayout(4,2));

        pLogIn = new JPanel(new BorderLayout(10,10));
        pLogInCenter = new JPanel(new GridLayout(4,2));

        pCorrect = new JPanel(new BorderLayout(10,10));

        pIncorrect = new JPanel(new BorderLayout(10,10));

        lSignUp = new JLabel("Sign Up");
        lSignUp.setHorizontalAlignment(JLabel.CENTER);
        lSignUp.setVerticalAlignment(JLabel.CENTER);

        lUsername1 = new JLabel("Username:");
        lUsername1.setVerticalAlignment(JLabel.CENTER);
        lUsername1.setHorizontalAlignment(JLabel.CENTER);

        lPassword1 = new JLabel("Password:");
        lPassword1.setVerticalAlignment(JLabel.CENTER);
        lPassword1.setHorizontalAlignment(JLabel.CENTER);

        lRePassword = new JLabel("Re-Password:");
        lRePassword.setVerticalAlignment(JLabel.CENTER);
        lRePassword.setHorizontalAlignment(JLabel.CENTER);

        lLogIn = new JLabel("Log In");
        lLogIn.setVerticalAlignment(JLabel.CENTER);
        lLogIn.setHorizontalAlignment(JLabel.CENTER);

        lUsername2 = new JLabel("Username:");
        lUsername2.setVerticalAlignment(JLabel.CENTER);
        lUsername2.setHorizontalAlignment(JLabel.CENTER);

        lPassword2 = new JLabel("Password:");
        lPassword2.setVerticalAlignment(JLabel.CENTER);
        lPassword2.setHorizontalAlignment(JLabel.CENTER);

        txtUsername1 = new JTextField();
        txtPassword1 = new JPasswordField();
        txtRePassword = new JPasswordField();

        txtUsername2 = new JTextField();
        txtPassword2 = new JPasswordField();

        btnSignUp = new JButton("Sign Up");
        btnClear1 = new JButton("Clear");

        btnLogIn = new JButton("Log In");
        btnClear2 = new JButton("Clear");

        lYourAttempts = new JLabel("Your attempts have only:");
        lYourAttempts.setVerticalAlignment(JLabel.CENTER);
        lYourAttempts.setHorizontalAlignment(JLabel.CENTER);

        lAttempts = new JLabel();
        lAttempts.setText(String.valueOf(attemps));
        lAttempts.setForeground(Color.RED);
        lAttempts.setVerticalAlignment(JLabel.CENTER);
        lAttempts.setHorizontalAlignment(JLabel.CENTER);

        pSignUpCenter.add(lSignUp);
        pSignUpCenter.add(lUsername1);
        pSignUpCenter.add(txtUsername1);
        pSignUpCenter.add(lPassword1);
        pSignUpCenter.add(txtPassword1);
        pSignUpCenter.add(lRePassword);
        pSignUpCenter.add(txtRePassword);
        pSignUpCenter.add(btnSignUp);
        pSignUpCenter.add(btnClear1);

        pSignUp.add(lSignUp,BorderLayout.NORTH);
        pSignUp.add(pSignUpCenter, BorderLayout.CENTER);

        ImageIcon imgCorrect = new ImageIcon("asset/check.jpg");
        lCorrect = new JLabel("Welcome to our application");
        lCorrect.setForeground(Color.GREEN);
        lCorrect.setIcon(imgCorrect);
        lCorrect.setVerticalTextPosition(JLabel.TOP);
        lCorrect.setHorizontalTextPosition(JLabel.CENTER);
        lCorrect.setIconTextGap(15);
        lCorrect.setHorizontalAlignment(JLabel.CENTER);
        lCorrect.setVerticalAlignment(JLabel.CENTER);

        ImageIcon imgInCorrect = new ImageIcon("asset/not-allow.png");
        lInCorrect = new JLabel("You have used all of 3 attempts!!!");
        lInCorrect.setForeground(Color.RED);
        lInCorrect.setIcon(imgInCorrect);
        lInCorrect.setHorizontalTextPosition(JLabel.CENTER);
        lInCorrect.setVerticalTextPosition(JLabel.TOP);
        lInCorrect.setIconTextGap(15);
        lInCorrect.setVerticalAlignment(JLabel.CENTER);
        lInCorrect.setHorizontalAlignment(JLabel.CENTER);

        pLogInCenter.add(lLogIn);
        pLogInCenter.add(lUsername2);
        pLogInCenter.add(txtUsername2);
        pLogInCenter.add(lPassword2);
        pLogInCenter.add(txtPassword2);
        pLogInCenter.add(btnLogIn);
        pLogInCenter.add(btnClear2);
        pLogInCenter.add(lYourAttempts);
        pLogInCenter.add(lAttempts);

        pLogIn.add(lLogIn,BorderLayout.NORTH);
        pLogIn.add(pLogInCenter, BorderLayout.CENTER);

        pCorrect.add(lCorrect,BorderLayout.CENTER);

        pIncorrect.add(lInCorrect,BorderLayout.CENTER);

        btnClear1.addActionListener(this);
        btnClear2.addActionListener(this);
        btnSignUp.addActionListener(this);
        btnLogIn.addActionListener(this);

        pMain.add(pSignUp, "Sign Up");
        pMain.add(pLogIn, "Log In");
        pMain.add(pCorrect,"Correct");
        pMain.add(pIncorrect,"Incorrect");

        frame.add(pMain);
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSignUp){
            String pwdTemp = Arrays.toString(txtPassword1.getPassword());
            String repwdTemp = Arrays.toString(txtRePassword.getPassword());
            if(pwdTemp.compareToIgnoreCase(repwdTemp)==0){
                varUsername = txtUsername1.getText();
                varPassword = pwdTemp;
                cl.next(pMain);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Password. Try again!!!");
            }
        }else if(e.getSource() == btnClear1){
            txtUsername1.setText("");
            txtPassword1.setText("");
            txtRePassword.setText("");
        }else if(e.getSource() == btnClear2){
            txtUsername2.setText("");
            txtPassword2.setText("");
        }else if(e.getSource() == btnLogIn){
            String userTemp = txtUsername2.getText();
            String pwdTemp = Arrays.toString(txtPassword2.getPassword());
            if(attemps == 1){
                cl.show(pMain,"Incorrect");
            }else{
                if((varUsername.compareToIgnoreCase(userTemp)==0)&&varPassword.compareToIgnoreCase(pwdTemp)==0){
                    cl.show(pMain,"Correct");
                }else{
                    attemps--;
                    lAttempts.setText(String.valueOf(attemps));
                }
            }
        }
    }
}
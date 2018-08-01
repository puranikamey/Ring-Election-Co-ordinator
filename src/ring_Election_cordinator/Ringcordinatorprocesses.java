package ring_Election_cordinator;
///1001451390
///AMEY JAYANT PURANIK

import java.net.*; //imorting the .net package.
import java.io.*; //importing the input /output package.
import java.util.*; // importing the java util package for array, string... etc handling

public class Ringcordinatorprocesses extends javax.swing.JFrame 
{
    String processname, pid , ip_address = "localhost";  // declaring the global  string variables 
    ArrayList<String> rename = new ArrayList(); //creating the arraylist 
    int port = 7044; //declaring the port number 
    Boolean Connected = false; //flag variables 
    Boolean cordinator =true; //flag variables 
    
    Socket Skt; // declaring the socket variables
    BufferedReader reader;
    PrintWriter writer;
    

   public void processunique(String data)  // method for uniqueue process
    {
      ring_display.append("Could not send Disconnect message.\n");
    }
   
   public void procidentification (String data)  //method for process identification
    {
      ring_display.append("Could not send Disconnect message.\n");;
    }
  
    
    public void processAdd(String data) //method for adding the nes process
    {
      rename.add(data); // adding elements in the arryalist 
    }
   
    
    public void processremove(String data)  // removing  the element form the arraylist
    {
    ring_display.append(data + " is now offline.\n");
    }
    
    //--------------------------//
    
    public void processappend()  
    {
         String[] tempList = new String[(rename.size())];
         rename.toArray(tempList);
         for (String token:tempList) 
         {
             //users.append(token + "\n");
         }
    }
    
    //--------------------------//
    
    public void process_send_terminated()  //method to terminate the process and send message
    {
        String bye = (processname + ": :Disconnect");
        try
        {
            writer.println(bye); 
            writer.flush(); 
        } catch (Exception e) 
        {
            ring_display.append("Could not send Disconnect message.\n");
        }
    }
    //method to terminate the process and send message
    public void terminated() 
    {
        try 
        {
            ring_display.append("Disconnected.\n");
            Skt.close();
        } catch(Exception ex) {
            ring_display.append("Failed to disconnect. \n");
        }
        Connected = false;
        ring_processname.setEditable(true);

    }
    //method for parring the cordinator 
    public void Electioncordinator (int  election){
        
                    
         ring_display.append("the process with the pid : " + election + " is a cordinator" );
         
    
    }
    //method to  start the thread
     public void echo_thrd() 
    {      Thread IncomingReader = new Thread(new messagespliting());
         IncomingReader.start();
    }
    //cordinator method
    public void int_cordinator (){
       String   one="one",two="two",three="three",four="four" , five="five";  
    if (processname.equals(two )&& processname.equals(three )&& processname.equals(four ) )
    {
    ring_display.append(" Process one is the cordinatorer");
    }
    }
    
    public Ringcordinatorprocesses() 
    {
        initComponents();
    }
    
  
    //implementating the thread using the runnable.
    public class messagespliting implements Runnable
    {
        @Override
        public void run() 
        {
     String[] data; //declaring the string variables 
   String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat", disconnected="disconnected" ;
   String   one="one",two="two",three="three",four="four" , five="five";  //changes done for five p
  int process_id [] ={10, 12, 13, 1}; //integerarray
  if (Connected==false){ 
  processname = ring_processname.getText();
  ring_processname.setEditable(false);
  pid=tring_id.getText();
  tring_id.setEditable(false);
            } 
            try 
            {     // reading the incomingmessage.
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":"); // spliting the data 

        if (data[0].equals(one) && pid.equals(two))  // condition for diaplaying the message on two from one 
    {
         if(data[1].equals(disconnected) && data[0].equals (one) && pid.equals(two ) && data [4].equals(two) )
            {
             ring_display.append(  "Process Indentification" + ": " + process_id [1] + ":" + process_id [2] + ":"+ process_id [3] +"\n");
             ring_display.setCaretPosition(ring_display.getDocument().getLength());
                        
                        
            }
                         else{
                        ring_display.append(data[0] + ": " + data[1] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                         }
                     } 
                     // condition for dialaying the message from message on three from two
                     else 
                         if (data[0].equals(two) && pid.equals(three))
                     {
                         
                         if(data[1].equals(disconnected) && data[0].equals (two) && pid.equals(three)&& data[5].equals (three))    //trial for three sending three messages 
                         
                         {
                          ring_display.append(  "Process Indentification" + ": " + process_id [2] + ":" + process_id [3] + ":"+ process_id [0] +"\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                        
                         }
                         
                         else{
                         ring_display.append(data[0] + ": " + data[1] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength()); }
                         
                     } 
                         //Displaying message on four from three////
                      else 
                         if (data[0].equals(three) && pid.equals(four))        //trial for sending third message when process three is downthree
                     {
                         if(data[1].equals(disconnected) && data[0].equals (three) && pid.equals(four) && data [6].equals(four))
                         {
                             ring_display.append(  "Process Indentification" + ": " + process_id [3] + ":" + process_id [0] + ":"+ process_id [1] +"\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                        
                         }
                         else{
                         ring_display.append(data[0] + ": " + data[1] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                         }
                     }
                         //////displaying message on one from four //////
                      else 
                         if (data[0].equals(four) && pid.equals(one))  //trial when four goes down ... plus sending the third message.
                     {
                             if(data[1].equals(disconnected) && data[0].equals (four) && pid.equals(one) && data [3].equals(one))
                             {
                             ring_display.append(  "Process Indentification" + ": " + process_id [0] + ":" + process_id [1] + ":"+ process_id [2] +"\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                        
                             }
                             else{
                         ring_display.append(data[0] + ": " + data[1] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                             }
                     }
           
      
                     else if (data[2].equals(connect)) // condition to check if process are connected.
                     {
                        ring_display.removeAll();
                        processAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) // condition to check if process are disconnected.
                     {
                         processremove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        processappend();
                        rename.clear();
             
                       
                     }
                     else if (data[1].equals(disconnected) && data[0].equals (two) && pid.equals(four))   // condition when of process 2 goes down
                     {
                        //users.setText("");
                        ring_display.append(  "Process Indentification" + ": " + process_id [2] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                        
                        
                        
                     }
                     else if (data[1].equals(disconnected) && data[0].equals (two) && pid.equals(one)&& data[3].equals (one))   //condition when of process 2 goes down
                     {
                        //users.setText("");
                        ring_display.append(  "Process Indentification" + ": " + process_id [2] + ":" + process_id [3] +  "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                        
                        
                        
                     }
                   
                     
                     else if (data[1].equals(disconnected) && data[0].equals (three) && pid.equals(one))  //condition if process 3 goes down
                     {
                        //users.setText("");
                        ring_display.append("Process Indentification" + ": " + process_id [3] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                     }
                     
                     else if (data[1].equals(disconnected) && data[0].equals (three) && pid.equals(two) && data [4].equals(two))  //condotion if process 3 goes down
                     {
                       //users.setText("");
                        ring_display.append(  "Process Indentification" + ": " + process_id [3] + ":" + process_id [0] +  "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                     }
                    
                     
                     else if (data[1].equals(disconnected) && data[0].equals (four) && pid.equals(two)) //condition if process 4  goes down
                     {
                        //users.setText("");
                        ring_display.append("Process Indentification" + ": " + process_id [0] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                     }
                     
                     else if (data[1].equals(disconnected) && data[0].equals (four) && pid.equals(three ) && data [5].equals(three))  //condition if process 4 goes down
                     {
                       //users.setText("");
                        ring_display.append(  "Process Indentification" + ": " + process_id [0] + ":" + process_id [1] +  "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                     }
                    
                     
                     else if (data[1].equals(disconnected) && data[0].equals (one) && pid.equals(three))  //condition if process one goes down..
                     {
                        //users.setText("");
                        ring_display.append("Process Indentification" + ": " + process_id [1] + "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                     }
                      else if (data[1].equals(disconnected) && data[0].equals (one) && pid.equals(four ) && data [6].equals(four))  //condition if process 1 goes down
                     {
                       //users.setText("");
                        ring_display.append(  "Process Indentification" + ": " + process_id [1] + ":" + process_id [2] +  "\n");
                        ring_display.setCaretPosition(ring_display.getDocument().getLength());
                     }
                     
                     ///conditions for comparing the process ids./////

                     if(data[1].equals(disconnected) && process_id [1] > process_id [2] && process_id [1] > process_id [3]){
                        
                            Electioncordinator(process_id [1]);
                        
                        }
                    else  if(data[1].equals(disconnected) && process_id [2] > process_id [1] && process_id [2] >process_id [3] ){
                        
                        Electioncordinator(process_id [2]);
                        }
                    else    if(data[1].equals(disconnected) && process_id [3]> process_id [1] && process_id [3] > process_id [2]){
                        
                        Electioncordinator(process_id [3]);
                        
                        }
                     
                     
                   
                      
                    else  if(data[1].equals(disconnected) && process_id [2] > process_id [3] && process_id [2] >process_id [0] ){
                        
                        Electioncordinator(process_id [2]);
                        }
                    else    if(data[1].equals(disconnected) && process_id [3]> process_id [2] && process_id [3] > process_id [0]){
                        
                        Electioncordinator(process_id [3]);
                        
                        }
                   
                    else  if(data[1].equals(disconnected) && process_id [0] > process_id [2] && process_id [0] >process_id [3] ){
                        
                        Electioncordinator(process_id [0]);
                        }
                    else    if(data[1].equals(disconnected) && process_id [0]> process_id [1] && process_id [0] > process_id [3]){
                        
                        Electioncordinator(process_id [0]);
                        
                        }
                      else  if(data[1].equals(disconnected) && process_id [3] > process_id [0] && process_id [3] > process_id [1] ){
                        
                        Electioncordinator(process_id [3]);
                        }
                    else    if(data[1].equals(disconnected) && process_id [1]> process_id [3] && process_id [1] > process_id [0]){
                        
                        Electioncordinator(process_id [1]);
                        
                        }
                      else  if(data[1].equals(disconnected) && process_id [0] > process_id [1] && process_id [0] >process_id [2] ){
                        
                        Electioncordinator(process_id [0]);
                        }
                    
                     else    if(data[1].equals(disconnected) && process_id [1]> process_id [0] && process_id [1] > process_id [2]){
                        
                        Electioncordinator(process_id [1]);
                        
                        }
                     else    if(data[1].equals(disconnected) && process_id [2]> process_id [0] && process_id [2] > process_id [1]){
                        
                        Electioncordinator(process_id [2]);
                        
                        }
                   
                }
           }catch(Exception ex) { 
           
           }
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_port = new javax.swing.JLabel();
        processno = new javax.swing.JLabel();
        ring_processname = new javax.swing.JTextField();
        process = new javax.swing.JLabel();
        tring_id = new javax.swing.JTextField();
        process_con = new javax.swing.JButton();
        b_disconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ring_display = new javax.swing.JTextArea();
        ring_write = new javax.swing.JTextField();
        ring_send = new javax.swing.JButton();
        ring_port = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Client's frame");
        setName("client"); // NOI18N
        setResizable(false);

        lb_port.setText("Port :");

        processno.setText("process No :");

        ring_processname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ring_processnameActionPerformed(evt);
            }
        });

        process.setText("Process :");

        process_con.setText("Connect");
        process_con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                process_conActionPerformed(evt);
            }
        });

        b_disconnect.setText("Disconnect");
        b_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_disconnectActionPerformed(evt);
            }
        });

        ring_display.setColumns(20);
        ring_display.setRows(5);
        jScrollPane1.setViewportView(ring_display);

        ring_send.setText("SEND");
        ring_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ring_sendActionPerformed(evt);
            }
        });

        ring_port.setText("7044");

        jLabel1.setText("PROCESS");

        jLabel2.setText("1001451390");

        jLabel3.setText("Amey Jayant Puranik");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_port)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ring_port, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_disconnect))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(processno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(ring_processname, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tring_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(process_con)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ring_write, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ring_send, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 24, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_port)
                            .addComponent(ring_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_disconnect))
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ring_send, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(ring_write))
                        .addGap(18, 18, 18)
                        .addComponent(process_con)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ring_processname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(processno)
                            .addComponent(process)
                            .addComponent(tring_id))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ring_processnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ring_processnameActionPerformed
    
    }//GEN-LAST:event_ring_processnameActionPerformed
// Event for handleing the connection //connection button
    private void process_conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_process_conActionPerformed
        if (Connected == false) 
        {
         processname = ring_processname.getText(); // getting the process name form the user
         ring_processname.setEditable(false);
         pid=tring_id.getText();
       tring_id.setEditable(false);
   try 
     {
       Skt = new Socket(ip_address, port); // setting up the new socket 
        InputStreamReader streamreader = new InputStreamReader(Skt.getInputStream());// object for reading the incoming message 
          reader = new BufferedReader(streamreader);
         writer = new PrintWriter(Skt.getOutputStream());
          writer.println(processname + ":has connected.:Connect"); 
         writer.flush(); 
                Connected = true; 
            } 
            catch (Exception ex) // handling the exception
            {
                ring_display.append("Cannot Connect! Try Again. \n");
                ring_processname.setEditable(true);
            }
            
            echo_thrd();
            
        } else if (Connected == true) 
        {
            ring_display.append("process is  are already connected in the ring. \n");
        }
    }//GEN-LAST:event_process_conActionPerformed
//Event for handling the diconnect button.
    private void b_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_disconnectActionPerformed
        process_send_terminated();
        terminated();
        
    }//GEN-LAST:event_b_disconnectActionPerformed
//event for handling the send fucnctionality 
    private void ring_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ring_sendActionPerformed
        String nothing = "";
        if ((ring_write.getText()).equals(nothing)) {
            ring_write.setText("");
            ring_write.requestFocus();
        } else {
            try {
               writer.println(processname + ":" + ring_write.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                ring_display.append("Message was not sent. \n");
            }
            ring_write.setText("");
            ring_write.requestFocus();
        }

        ring_write.setText("");
        ring_write.requestFocus();
    }//GEN-LAST:event_ring_sendActionPerformed
// main class
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new Ringcordinatorprocesses().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_disconnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_port;
    private javax.swing.JLabel process;
    private javax.swing.JButton process_con;
    private javax.swing.JLabel processno;
    private javax.swing.JTextArea ring_display;
    private javax.swing.JTextField ring_port;
    private javax.swing.JTextField ring_processname;
    private javax.swing.JButton ring_send;
    private javax.swing.JTextField ring_write;
    private javax.swing.JTextField tring_id;
    // End of variables declaration//GEN-END:variables
}

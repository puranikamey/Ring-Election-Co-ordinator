
package ring_Election_cordinator;
///1001451390
///AMEY JAYANT PURANIK
import java.io.*;  //importing the input /output package.
import java.net.*;  //imorting the .net package.
import java.util.*; // importing the java util package for array, string... etc handling 

public class ringcordinatorserver extends javax.swing.JFrame {
ArrayList Processringoutburst;    ///creating the arraylist for the processoutput msg_ser .
    
    public void requestincoming()
    
    {  // method for incoming msg_ser processing.
        
    String Data= " ";
    r_display.append( Data + " request per process connected");
    
  
    }
 
   ArrayList<String> Processes; // arraylist for adding the  new process in the ring.

   public void requestoutgoing()
    
    {  // method for outgoing  msg_ser processing.
        
    String msgout= " ";
    r_display.append( msgout + " message  per process connected in the ring ");
    
  
    }
   
   
   public class manage_process implements Runnable  //thread for handling the process connections.	
   {
       BufferedReader reader; //initialize the bufferedreader vaiiable 
       Socket skt; //initialize the Socket variable
       PrintWriter client;

       public manage_process(Socket processskt, PrintWriter user)   // constructur for  handling the readingthe msg_ser form the process
       {
            client = user;
            try 
            {
                skt = processskt;
                InputStreamReader din = new InputStreamReader(skt.getInputStream());  //object for reading the incoming msg_ser from the process.
                reader = new BufferedReader(din);
            }
            catch (Exception ex) 
            {
                r_display.append("Unexpected error... \n");
            }

       }

       @Override
       public void run() 
       {        // initializing the string  variables 
            String msg_ser, connect = "Connect", disconnect = "Disconnect", chat = "Chat" , disconnected="disconnected" ;
            String[] split_info; // declaring the array 
            String one="one", two="two", three="three",four="four";  // initializing the string  variables
            try  {
                while ((msg_ser = reader.readLine()) != null) //while loop for reading the msg_ser from the buffer.
                {
                    r_display.append("Received: " + msg_ser + "\n"); //displaying the incoming msg_ser.
                    split_info = msg_ser.split(":"); //spliting the incoming msg_ser  using " :"
                    
                    for (String token:split_info)  //passig the token..
                    {
                        r_display.append(token + "\n"); //displaying the token
                    }

                    if (split_info[2].equals(connect))  //if else loop for checkeing if threre is any new connection.
                    {
                        Cir_in_ring((split_info[0] + ":" + split_info[1] + ":" + chat ));
                        processintegrated(split_info[0]);
                        
                    } 
                    else if (split_info[2].equals(disconnect))  // checking of the process is disconnected.
                    {
                        Cir_in_ring((split_info[0] + ":" + disconnected  + ":" + chat+ ":" + one + ":" +two + ":" + three+":" + four));
                        Processterminate(split_info[0]); //termination the processs
                    } 
                    else if (split_info[2].equals(chat))  
                    {
                        Cir_in_ring(msg_ser);
                    } 
                    else 
                    {
                        r_display.append("Please the given condition ..something went wrong  \n"); //displaying the exception.
                    }
                } 
             } 
             catch (Exception ex) 
             {                       //displaying the exception when there is lost of connection. handled exception..
                r_display.append("Lost a connection. \n");
                ex.printStackTrace();
                Processringoutburst.remove(client);
             } 
	} 
    }


    public ringcordinatorserver() {
        initComponents();
    }

   //self generated code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r_initiate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        r_display = new javax.swing.JTextArea();
        process_connected = new javax.swing.JButton();
        r_terminate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        r_initiate.setText("INITIATE");
        r_initiate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_initiateActionPerformed(evt);
            }
        });

        r_display.setColumns(20);
        r_display.setRows(5);
        jScrollPane1.setViewportView(r_display);

        process_connected.setText("PROCESS CONNECTED");
        process_connected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                process_connectedActionPerformed(evt);
            }
        });

        r_terminate.setText("TERMINATE");
        r_terminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_terminateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_initiate)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(process_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r_terminate)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(r_initiate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(process_connected)
                    .addComponent(r_terminate))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Event handling for the terminating the server.
    private void r_terminateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_terminateActionPerformed
        try 
        {
            Thread.sleep(3000);     //Making thread sleep in 3 seconds
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}   //Handling the thread exception
        
        Cir_in_ring("Server:is terminated.\n:Chat");
        r_display.append("Server terminating. \n");  ///appending that the server stopped.
        
        r_display.setText(""); //setting the display window to blank
    }//GEN-LAST:event_r_terminateActionPerformed
 ///handling the event to initialize the server
    private void r_initiateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_initiateActionPerformed
         Thread starter = new Thread(new initiate_backendserver()); //starting the thread server start.
        starter.start();
        
        r_display.append("Initiated..\n"); ///displaying when the server forst initiated.
    }//GEN-LAST:event_r_initiateActionPerformed
//Showing the online process connected.. at the moment.
    private void process_connectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_process_connectedActionPerformed
        r_display.append("\n Process connected  : \n");
        for (String process_inthering : Processes) 
        {
            r_display.append(process_inthering); //displaying the processs connected in the ring.
            r_display.append("\n");
        }
    }//GEN-LAST:event_process_connectedActionPerformed

    
    public static void main(String args[]) {   ///main class.
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ringcordinatorserver().setVisible(true);
            }
        });
    }
    
    // Thread initiate_backendserver implemented using runnable .
     public class initiate_backendserver implements Runnable 
    {
        @Override
        public void run() 
        {
            Processringoutburst = new ArrayList(); //a arraylist got process outgoing messages 
            Processes = new ArrayList();  

            try 
            {
         ServerSocket skt_server = new ServerSocket(7044);  //creating the server socket.

         while (true) 
          {
	Socket client_skt = skt_server.accept(); //accepting the process request.
	PrintWriter writer = new PrintWriter(client_skt.getOutputStream()); // object created for sending msg_ser out.
	Processringoutburst.add(writer); //Arraylist 

	Thread listener = new Thread(new manage_process(client_skt, writer));
        listener.start();
	r_display.append("Got a connection. \n");
          }
            }
            catch (Exception e)
            {
                r_display.append("Error due to lack of connection \n");
            }
        }
    }
     //method for terminating the processs 
    public void Processterminate (String data) 
    {  
        // initialize the string the variables 
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        Processes.remove(name); //arrarylist process to remive the asdded process
        String[] list_tmp = new String[(Processes.size())];   //temporary array for parring the token
        Processes.toArray(list_tmp);

        for (String token:list_tmp) 
        {
            message = (token + add);
            Cir_in_ring(message);
        }
      //  Cir_in_ring(done);
    }
    
    public void Cir_in_ring(String message)  // menthod for ciculating msg_ser in the ring // sending only msg_ser
    {
	Iterator it = Processringoutburst.iterator(); // an iterator to traverse through the arraylist.

        while (it.hasNext())  //while loop for traversing 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message); // sending the msg_ser to process
		r_display.append("Sending: " + message + "\n"); //// sending the msg_ser to process
                writer.flush(); // sending the msg_ser to process
                r_display.setCaretPosition(r_display.getDocument().getLength());

            } 
            catch (Exception e)  //handling Exception
            {
		r_display.append("Error occured.. \n");
            }
        } 
    }
    public void processintegrated (String data)  //method fot adding the new process and making the new connection.
    {
        //initializing the string variables.
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        r_display.append("process " + name + " added. \n");
        Processes.add(name);
       // r_display.append("After " + name + " added. \n");
        String[] interim_roll = new String[(Processes.size())];  //creating the tempeorary string array
        Processes.toArray(interim_roll);

        for (String token:interim_roll) 
        {
            message = (token + add);
            Cir_in_ring(message);
        }
        Cir_in_ring(done);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton process_connected;
    private javax.swing.JTextArea r_display;
    private javax.swing.JButton r_initiate;
    private javax.swing.JButton r_terminate;
    // End of variables declaration//GEN-END:variables
}

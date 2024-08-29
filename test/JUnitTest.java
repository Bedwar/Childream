
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import views.JGestor; 

public class JUnitTest {

    private JGestor jGestor;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws Exception {
       
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        
        jGestor = new JGestor();
        jGestor.conectar = mockConnection;
        jGestor.pcc = mockPreparedStatement;
        jGestor.rs = mockResultSet;
    }

    @Test
    public void testVer() throws Exception {
        
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString(4)).thenReturn("Test Name");
        when(mockResultSet.getString(2)).thenReturn("10");
        when(mockResultSet.getString(3)).thenReturn("Test");

       
        jGestor.ver();

        
        verify(mockPreparedStatement, times(1)).setString(1, jGestor.txtID.getText());
        assertEquals("Test Name", jGestor.txtNome.getText());
        assertEquals("10", jGestor.txtIda.getText());
        assertEquals("Test", jGestor.txtEnd.getText());
    }

    @Test
    public void testNovo() throws Exception {
        
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        
        jGestor.txtNome.setText("New Name");
        jGestor.txtIda.setText("12");
        jGestor.txtEnd.setText("New");

        
        jGestor.novo();

        
        verify(mockPreparedStatement, times(1)).setString(1, "New Name");
        verify(mockPreparedStatement, times(1)).setString(2, "12");
        verify(mockPreparedStatement, times(1)).setString(3, "New");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testAlterar() throws Exception {
        
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        
        jGestor.txtID.setText("1");
        jGestor.txtNome.setText("Updated Name");
        jGestor.txtIda.setText("15");
        jGestor.txtEnd.setText("Updated");

        
        jGestor.alterar();

        
        verify(mockPreparedStatement, times(1)).setString(1, "Updated Name");
        verify(mockPreparedStatement, times(1)).setString(2, "15");
        verify(mockPreparedStatement, times(1)).setString(3, "Updated");
        verify(mockPreparedStatement, times(1)).setString(4, "1");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testDelete() throws Exception {
        
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        
        jGestor.txtID.setText("1");
      
        jGestor.delete();

        
        verify(mockPreparedStatement, times(1)).setString(1, "1");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
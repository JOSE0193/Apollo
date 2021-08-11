package br.com.limaconsultoria.apollo.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.limaconsultoria.apollo.domain.Usuario;
import br.com.limaconsultoria.apollo.janela.JanelaImportar;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.writer.SpreadsheetWriter;

public class ImportarAction implements ActionListener {

	JFileChooser fc = new JFileChooser();
	JPanel painel = new JPanel();
	JTextField tx = new JTextField();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JanelaImportar janela = new JanelaImportar();
		
		tx.setColumns(30);
		
		janela.add(painel, BorderLayout.PAGE_END);
		painel.add(tx);
		painel.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showSaveDialog(janela);
		
		File file = fc.getSelectedFile();
		tx.setText(file.getPath());
		
		File xlsFile = new File(file.getPath());
		XlsReader reader = new XlsReader();
		
		try {
			
			List<Usuario> usuarios = reader.read(Usuario.class, xlsFile);
			
			List<Usuario> novosUsuarios = new ArrayList<Usuario>();
			usuarios.forEach((usuario) -> {
				Usuario lista = new Usuario();
				lista.setNome(usuario.getNome().toUpperCase());
				lista.setNomeMae(usuario.getNomeMae().toUpperCase());
				novosUsuarios.add(lista);
			});
			
			SpreadsheetWriter writer = new SpreadsheetWriter("/home/katiene/Documentos/José/Material Java/Usuario.xls");
			writer.addSheet(Usuario.class, novosUsuarios);
			writer.write();	
			}
		
			catch (SpreadsheetReadException | IOException e) {
				e.printStackTrace();
			}	
	}
	
}

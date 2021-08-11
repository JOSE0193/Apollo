package br.com.limaconsultoria.apollo.janela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.limaconsultoria.apollo.action.ImportarAction;

public class JanelaImportar extends JFrame{

	JButton botao1 = new JButton();
	JPanel painel = new JPanel();
	
	public JanelaImportar() {
		
		setTitle("Carregar Planilha");
		setSize(420, 420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImportarAction action = new ImportarAction();
    	botao1.addActionListener(action);
		botao1.setText("Procurar");
		
		painel.setBackground(Color.LIGHT_GRAY);
		painel.setPreferredSize(new Dimension(420, 200));
		painel.add(botao1, BorderLayout.WEST);
			
		add(painel, BorderLayout.PAGE_START);
		
		setVisible(true);
	}
	
}

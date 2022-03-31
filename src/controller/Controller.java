package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import exceptions.InvalidInputException;
import model.Echipa;
import model.Manangement;
import view.BusinessView;
import view.MainView;

public class Controller {
	private MainView m_view;
	private Manangement m_model;
	private Echipa echipe;
	
	public Controller (MainView view, Manangement model, Echipa team) throws NumberFormatException{
		this.m_model=model;
		this.m_view=view;
		this.echipe=team;
		
		m_view.addBtnListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Echipa newTeam = new Echipa();
				newTeam.setNume(m_view.getTeamText().toUpperCase());
				newTeam.setStadion(m_view.getStadiumEnumElement());
				try {
					if (Integer.parseInt(m_view.getYearText())>0) {
						newTeam.setAnFondare(Integer.parseInt(m_view.getYearText()));
						model.addTeam(newTeam.getNume());
						echipe.addTeam(newTeam);
						m_view.showMsj("Echipa adaugata cu succes!");
					}
				} catch (NumberFormatException x) {
					m_view.showMsj("An fondare invalid!");
				}
			}
			
		});
		
		m_view.manageBtnListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (echipe.getNumberOfTeams()>1)
				{
					BusinessView nextView= new BusinessView();
					Iterator<Echipa> it =echipe.getTeams().iterator();
					while (it.hasNext()) {
						Echipa team= it.next();
						nextView.comboBox1().addItem(team.getNume());
						nextView.comboBox2().addItem(team.getNume());
						
					}
					
					nextView.addBtnListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String t1 = nextView.getTeam1Element();
							String t2 = nextView.getTeam2Element();
							try {
							m_model.addFriendship(t1, t2);
							}	
							catch (InvalidInputException x) {
								nextView.showMsj(x.getMessage());
							}
						}
						
					});
					
					nextView.viewBtnListener(new ActionListener () {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							nextView.showMsj(model.toString());
						}
						
					});
				}
			}
		});
		
		m_view.showManangeBtnListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				m_view.showManageMsj().setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				m_view.showManageMsj().setVisible(false);
			}
			
		});
	}
	
	
}

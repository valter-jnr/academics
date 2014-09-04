package br.com.consulti.academics.controller;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@Named
@SessionScoped
public class DashboardBean implements Serializable {

	private DashboardModel model;
	
	public DashboardBean() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
                
		//DashboardColumn column2 = new DefaultDashboardColumn();
		
		column1.addWidget("Lixeira");
		column1.addWidget("Usuários");
		
		column1.addWidget("Adicionar");
		column1.addWidget("Desativar");
		

		model.addColumn(column1);
		
	}
	
	public void handleReorder(DashboardReorderEvent event) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Reordered: " + event.getWidgetId());
		message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
		
		addMessage(message);
	}
	
	
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public DashboardModel getModel() {
		return model;
	}
}
			
package wb;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.util.regex.Pattern;
import org.eclipse.wb.swt.SWTResourceManager;

public class AppAparca {

	protected Shell shlAppaparcaDeAgenjo;
	private Group grpDadesVehicle;
	private Group grpDadesEstacionament;
	private Group grpErrorsIAlertes;
	private Label lblMatrcula;
	private Label lblEtiqueta;
	private Label lblTempsAparcaten;
	private Label lblResident;
	private Label lblElPreuDe;
	private Label lblEuros;
	private Text textMatricula;
	private Text textTempsAparcat;
	private Text textPreuTotal;
	private Combo comboEtiqueta;
	private Combo comboResident;
	private Button btnValidar;
	private Button btnRestaurar;
	private Button btnCalcular;
	private Label lblError;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppAparca window = new AppAparca();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAppaparcaDeAgenjo.open();
		shlAppaparcaDeAgenjo.layout();
		while (!shlAppaparcaDeAgenjo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAppaparcaDeAgenjo = new Shell();
		shlAppaparcaDeAgenjo.setImage(SWTResourceManager.getImage(AppAparca.class, "/com/aparca/icon/parking.ico"));
		shlAppaparcaDeAgenjo.setSize(469, 503);
		shlAppaparcaDeAgenjo.setText("AppAparca de Agenjo");

		grpDadesVehicle = new Group(shlAppaparcaDeAgenjo, SWT.NONE);
		grpDadesVehicle.setText("Dades Vehicle");
		grpDadesVehicle.setBounds(10, 10, 434, 139);

		lblMatrcula = new Label(grpDadesVehicle, SWT.NONE);
		lblMatrcula.setBounds(10, 28, 55, 15);
		lblMatrcula.setText("Matrícula");

		lblEtiqueta = new Label(grpDadesVehicle, SWT.NONE);
		lblEtiqueta.setBounds(10, 81, 55, 15);
		lblEtiqueta.setText("Etiqueta");

		textMatricula = new Text(grpDadesVehicle, SWT.BORDER);
		textMatricula.setToolTipText("Matrícula Vehicle");
		textMatricula.setBounds(71, 25, 107, 21);

		comboEtiqueta = new Combo(grpDadesVehicle, SWT.NONE);
		comboEtiqueta.setToolTipText("Etiqueta Vehicle");
		comboEtiqueta.setItems(new String[] { "0", "ECO", "C", "B", "Sense Distintiu" });
		comboEtiqueta.setBounds(71, 78, 107, 23);

		btnValidar = new Button(grpDadesVehicle, SWT.NONE);
		btnValidar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ValidateButton();
			}
		});
		btnValidar.setBounds(290, 49, 75, 25);
		btnValidar.setText("VALIDAR");

		grpDadesEstacionament = new Group(shlAppaparcaDeAgenjo, SWT.NONE);
		grpDadesEstacionament.setText("Dades Estacionament");
		grpDadesEstacionament.setBounds(10, 155, 434, 244);

		lblTempsAparcaten = new Label(grpDadesEstacionament, SWT.NONE);
		lblTempsAparcaten.setBounds(10, 39, 146, 15);
		lblTempsAparcaten.setText("Temps aparcat (en minuts): ");

		lblResident = new Label(grpDadesEstacionament, SWT.NONE);
		lblResident.setBounds(10, 83, 55, 15);
		lblResident.setText("Resident");

		lblElPreuDe = new Label(grpDadesEstacionament, SWT.NONE);
		lblElPreuDe.setBounds(26, 195, 172, 15);
		lblElPreuDe.setText("El preu de l'aparcament serà de");

		lblEuros = new Label(grpDadesEstacionament, SWT.NONE);
		lblEuros.setBounds(286, 195, 55, 15);
		lblEuros.setText("euros.");

		textTempsAparcat = new Text(grpDadesEstacionament, SWT.BORDER);
		textTempsAparcat.setToolTipText("Temps aparcat en minuts");
		textTempsAparcat.setEnabled(false);
		textTempsAparcat.setBounds(161, 36, 76, 21);

		textPreuTotal = new Text(grpDadesEstacionament, SWT.BORDER);
		textPreuTotal.setToolTipText("Total preu aparcament");
		textPreuTotal.setEnabled(false);
		textPreuTotal.setBounds(204, 192, 76, 21);

		comboResident = new Combo(grpDadesEstacionament, SWT.NONE);
		comboResident.setToolTipText("Resident?");
		comboResident.setItems(new String[] { "Sí", "No" });
		comboResident.setEnabled(false);
		comboResident.setBounds(71, 80, 91, 23);

		btnRestaurar = new Button(grpDadesEstacionament, SWT.NONE);
		btnRestaurar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RestoreButton();
			}
		});
		btnRestaurar.setEnabled(false);
		btnRestaurar.setBounds(290, 73, 75, 25);
		btnRestaurar.setText("RESTAURAR");

		btnCalcular = new Button(grpDadesEstacionament, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculateButton();
			}
		});
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(193, 143, 75, 25);
		btnCalcular.setText("CALCULAR"); 

		grpErrorsIAlertes = new Group(shlAppaparcaDeAgenjo, SWT.NONE);
		grpErrorsIAlertes.setText("Errors i Alertes");
		grpErrorsIAlertes.setBounds(10, 405, 434, 51);

		lblError = new Label(grpErrorsIAlertes, SWT.NONE);
		lblError.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblError.setBounds(10, 26, 414, 15);

	}

	private void CalculateButton() {
		CleanError();
		textPreuTotal.setText("");
		if (ValidateDadesEstacionament()) {
			textPreuTotal.setText(Double.toString(CalcularPreuAparcament()));
		} 
	}

	private double CalcularPreuAparcament() {
		double preuTotal = 0;
		double tempsAparcat = Double.parseDouble(textTempsAparcat.getText());
		
		switch (comboEtiqueta.getText()) {
		case "0":
			preuTotal = tempsAparcat / 60 * 0.25;
			break;
		case "ECO":
			preuTotal = tempsAparcat / 60 * 1;
			break;
		case "C":
			preuTotal = tempsAparcat / 60 * 1.75;			
			break;
		case "B":
			preuTotal = tempsAparcat / 60 * 2.25;			
			break;
		case "Sense Distintiu":
			preuTotal = tempsAparcat / 60 * 3;			
			break;
		default:
			break;	
		}
		
		if (IsResident())
			preuTotal /= 2;
		
		return Math.floor(preuTotal * 100) / 100;
	}
	
	private boolean IsResident() {
		return comboResident.getText().equals("Sí");
	}

	private void ValidateButton() {
		CleanError();
		if (ValidateDadesVehicle()) {
			SetVisibilityDadesVehicle(false);
			SetVisibilityDadesEstacionament(true);
		}
	}

	private void RestoreButton() {
		SetVisibilityDadesVehicle(true);
		CleanDadesVehicle();
		SetVisibilityDadesEstacionament(false);
		CleanDadesEstacionament();
		CleanError();
	}

	private void CleanDadesVehicle() {
		textMatricula.setText("");
		comboEtiqueta.deselectAll();
	}

	private void CleanDadesEstacionament() {
		textTempsAparcat.setText("");
		comboResident.setText("");
		comboEtiqueta.deselectAll();
		textPreuTotal.setText("");
	}

	private void SetVisibilityDadesEstacionament(boolean visibility) {
		textTempsAparcat.setEnabled(visibility);
		comboResident.setEnabled(visibility);
		btnRestaurar.setEnabled(visibility);
		btnCalcular.setEnabled(visibility);
		textPreuTotal.setEnabled(visibility);
	}

	private void SetVisibilityDadesVehicle(boolean visibility) {
		textMatricula.setEnabled(visibility);
		comboEtiqueta.setEnabled(visibility);
		btnValidar.setEnabled(visibility);
	}

	private boolean ValidateDadesEstacionament() {
		if (!ValidateTempsAparcat())
			return false;
		if (!ValidateResident())
			return false;
		return true;
	}

	private boolean ValidateResident() {
		if (comboResident.getSelectionIndex() > -1) {
			return true;
		}

		ShowError("Has de seleccionar resident SI o NO");
		comboResident.setFocus();
		return false;
	}

	private boolean ValidateTempsAparcat() {
		String error = "";
		String tempsAparcat = textTempsAparcat.getText().trim();
		if (tempsAparcat.equals("")) {
			error = "El camp Temps Aparcat no pot ser buit";
		} else if (!IsNumeric(tempsAparcat)) {
			error = "Temps aparcat ha de ser numeric";
		} else if (comboResident.getText().equals("No") & Integer.parseInt(tempsAparcat) > 120) {
			error = "Per a NO residents el temps máxim es de 2h";
		} else if (Integer.parseInt(tempsAparcat) < 1)
			error = "Temps aparcat ha de ser major de 0";

		if (error != "") {
			ShowError(error);
			textTempsAparcat.setFocus();
			textTempsAparcat.selectAll();
		}

		return error == "";
	}

	private boolean IsNumeric(String value) {
		if (value == null) {
			return false;
		}
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private boolean ValidateDadesVehicle() {
		String error = "";
		if (!ValidateMatricula()) {
			error = "Matricula " + textMatricula.getText() + " no válida";
			textMatricula.setFocus();
			textMatricula.selectAll();
		} else if (!ValidateEtiqueta()) {
			error = "Has de seleccionar una etiqueta válida";
			comboEtiqueta.setFocus();
		}

		if (error != "")
			ShowError(error);

		return error == "";
	}

	private boolean ValidateMatricula() {
		return Pattern.matches("^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}", textMatricula.getText());
	}

	private boolean ValidateEtiqueta() {
		return comboEtiqueta.getSelectionIndex() > -1;
	}

	private void ShowError(String text) {
		lblError.setText(text);
	}
	
	private void CleanError() {
		lblError.setText("");
	}
	
	private void TestGitPush() {
		
	}
}

package cavalcante.gouvea.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btnEnviar); // e obtemos o botão btnEnviar, isso é feito através do método findViewById, passando como parâmetro o id do botão.
        btnEnviar.setOnClickListener(new View.OnClickListener() { // captura o evento de click do botão. Quando o botão for clicado, o método onClick  será chamado.
            @Override
            public void onClick(View v) {
                //obtendo dados digitados pelo usuario

                //dados de email
                EditText etEmail = (EditText)findViewById(R.id.etEmail); // obter email por id
                String email = etEmail.getText().toString(); // passar o texto no campo email para string

                //dados Assunto
                EditText etAssunto = findViewById(R.id.etAssunto); // obter assunto por id
                String assunto = etAssunto.getText().toString(); // passar o texto no campo assunto para string

                // dados texto
                EditText etTexto = findViewById(R.id.etTexto); // obter texto por id
                String texto = etTexto.getText().toString(); // passar o texto no campo texto para string

                Intent i = new Intent(Intent.ACTION_SENDTO); // criamos uma intent para a ação sendto

                i.setData(Uri.parse("mailto:")); // definimos a ação que queremos resolver, email para alguem
                String[] emails = new String[] {email}; // criamos um lista de strings emails
                i.putExtra(Intent.EXTRA_EMAIL, emails); // destino email
                i.putExtra(Intent.EXTRA_SUBJECT, emails); // assunto
                i.putExtra(Intent.EXTRA_TEXT, emails); // texto

                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP")); // chamamos o try para executar a acao
                }
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nennhum app que possa realizar essa operação", Toast.LENGTH_LONG).show(); // deu merda? vai falar que a opracoa nao funcionou
                }

            }
        });
    }
}
<!-- ================================================================================
		Halitech Dev by Giovani Paganini - Contact Form designed for Halitech Dev
	================================================================================= -->
	

<?php	
	if (isset($_POST["submit"])) {
		$para = 'contato@halitech.org';
		$assunto = 'Contato pelo Site';
		$nome = $_POST['name'];
		$email = $_POST['email'];		
		$subject = $_POST['subject'];
		$msg = $_POST['textarea'];
		$spam = intval($_POST['human']);
		
			$corpo = "<strong> Mensagem de Contato </strong><br><br>";
			$corpo .= "<strong> Nome: </strong> $nome";
			$corpo .= "<br><strong> Email: </strong> $email";			
			$corpo .= "<br><strong> Assunto: </strong> $subject";
			$corpo .= "<br><strong> Mensagem: </strong> $msg";
			
			$header = "Content-Type: text/html; charset= utf-8\n";
			$header .= "From: $email Reply-to: $email\n";
			
		
		
		// Verificar se o nome foi preenchido
		if (!$_POST['name']) {
			$errName = 'Por favor, digite seu nome';
		}
		
		// Verificar se o email foi preenchido e é válido
		if (!$_POST['email'] || !filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)) {
			$errEmail = 'Por favor, use um endereço de email válido';
		}
			
		// Verificar se o assunto foi preenchido
		if (!$_POST['subject']) {
			$errSubject = 'Por favor, digite um assunto';
		}
		
		// Verificar se a mensagem foi preenchida
		if (!$_POST['textarea']) {
			$errMessage = 'Por favor, escreva sua mensagem';
		}
		// Verificar se o anti-spam está correto
		if ($spam !== 7) {
			$errHuman = 'Seu anti-spam está incorreto';
		}
// Se não houver nenhum erro, enviar email
if (!$errName && !$errEmail && !$errFone && !$errSubject && !$errMessage && !$errHuman) {
	if (mail ($para, $assunto, $corpo, $header)) {
		$result='<div class="data-success">Obrigado! Entraremos em contato.</div>';
	} else {
		$result='<div class="alert alert-danger">Desculpe, ocorreu um erro ao enviar sua mensagem. Por favor, tente novamente mais tarde.</div>';
	}
}
	}
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>Halitech Dev - Criação de Sites</title>
  
  <meta name="author" content="Giovani Paganini">
  <meta name="description" content="Desenvolvimento de sites responsivos e modernos atendendo suas necessidades.">
  <meta name="robots" content="all">

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link rel="shortcut icon" href="favicon.png"/>
  <script src="https://use.fontawesome.com/82f3f5046b.js"></script>
</head>
<body>
<div class="navbar-fixed">
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="#!	" class="brand-logo">Halitech Dev</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="index.html">Home</a></li>
		<li><a href="about.html">Sobre</a></li>
		<li><a href="services.html">Serviços</a></li>
		<li class="active"><a href="contact.html">Contato</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li class="active"><a href="index.html">Home</a></li>
		<li><a href="about.html">Sobre</a></li>
		<li><a href="services.html">Serviços</a></li>
		<li><a href="contact.php">Contato</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
</div>
<div class="section teal">
	<div class="container">		
			<div class="col s12 m4">
				<h4 class="white-text text-lighten-2">Contato <i class="fa fa-angle-double-right"></i></h4>
			</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col s6">
				<h3>Contate-nos</h3>
				<h5>Precisa falar conosco? Utilize o formulário ao lado. Será um prazer responder suas dúvidas!</h5>
				<h6>Ou envie-nos um email para <a href="mailto:contato@halitech.org">contato@halitech.org</a></h6>
			</div>
			<div class="col s6">
			<form class="col s12" method="post" action="contato.php">
				<div class="row">
					<div class="input-field col s12">
						<input id="name" type="text" placeholder="Nome" class="validate">
						<label for="name">Nome</label>
					</div>					
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="email" placeholder="Email" class="validate">
						<label for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="subject" type="text" placeholder="Assunto" length="20" class="validate">
						<label for="subject">Assunto</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<textarea id="textarea" class="materialize-textarea" length="160"></textarea>
						<label for="textarea">Mensagem</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input for="human" type="text" class="validate">
						<label for="human">4+3=</label>
					</div>
				</div>
				<button class="btn waves-effect waves-light" type="submit" name="action">Enviar
					<i class="material-icons right">send</i>
				</button>        
			</form>
			</div>
		</div>
	</div>
</div>  

  <footer class="page-footer teal">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Quem somos</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <!-- <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div> -->
        <div class="col l3 s12">
          <h5 class="white-text">Conecte-se</h5>
          <ul>
            <li><a class="white-text fa fa-facebook fa-2x" href="#!"></a></li>
            <li><a class="white-text fa fa-twitter fa-2x" href="#!"></a></li>
            <li><a class="white-text fa fa-github fa-2x" href="#!"></a></li>            
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      &copy; 2010-2016 Hali Technologies, All rights reserved. 
	  <a class="brown-text text-lighten-3 right" href="https://opensource.org/licenses/MIT">MIT License</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
  <script src="js/custom.js"></script>

  </body>
</html>

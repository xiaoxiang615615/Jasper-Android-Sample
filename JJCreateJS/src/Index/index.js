//(function (){
//	var test = "test";
//	function jasperTestClass(){
//		var _this = [];
//		_this.testMethod = function (){
//			alert("Hello world -- by Jasper");
//		}
//		return _this;
//	}
//	window.jasperTestClass = jasperTestClass;
//}());
//
//var jasperTest = new jasperTestClass();
//jasperTest.testMethod();

(function (){
	var test = "test1";	
	var stage = new createjs.Stage("mainView");
	createjs.Ticker.setFPS(30);
	createjs.Ticker.addEventListener("tick", tick);
	var gameView = new createjs.Container();
	stage.addChild(gameView);
	var n = 2;
	var isGameOver = false;
	var originalScore = 0;
	
	function tick(event) {
		output.text = "Time left = "+Math.round(30-createjs.Ticker.getTime(true)/1000);
		score.text = "Score = "+originalScore;
		stage.update(event); // important!!
		if(Math.round(30-createjs.Ticker.getTime(true)/1000) == 0 && !isGameOver)
		{
			isGameOver = true;
			console.log("Game over by Jasper");
			createjs.Ticker.reset();
			test2.addGameOver();
			gameover.text = "Game over by Jasper";
			stage.update();
		}
	}
	

	function mainView(){
		_this = [];

		var __construct = function(){

		}(this);
		
		_this.test = function(){
			alert(test+" working!!!!");
		}
		
		_this.addRect = function(x, y, width, height, color, withEvent){
			var rect = new createjs.Shape();
			rect.graphics.beginFill(color).drawRect(0, 0, width, height);
			rect.x = x;
			rect.y = y;
			if(withEvent)
			{
				rect.addEventListener("click", function(){
					//alert("This is the one");
					
					if(n < 9)
					{
						n++;
					}
					gameView.removeAllChildren();
					stage.removeChild(output);
					stage.removeChild(score);
					_this.createView();
					score.text = "Score = "+originalScore++;
					
				})
			}
			gameView.addChild(rect);
			
		}
		
		_this.createView = function(){
			_this.addTimer();
			_this.addScore();
			var x = parseInt(Math.random()*100%n);
			var y = parseInt(Math.random()*100%n);
			var cl = parseInt(Math.random()*1000000);
			while(cl.toString().length < 6)
			{
				 cl = parseInt(Math.random()*1000000);
			}
			var ranCl = parseInt(Math.random()*1000000);
			while(ranCl.toString().length < 6)
			{
				ranCl = parseInt(Math.random()*1000000);
			}
			var ranColor = "#"+cl;
			var ranClickColor = "#"+ranCl;
			console.log(ranColor+" "+ranClickColor);
			var random
			for(var i = 0; i < n; i++)
			{
				for(var j=0; j < n; j++)
				{
					if(i==x && j==y)
					{
						_this.addRect((380/n)*i, (380/n)*j, 380/n-5, 380/n-5, ranClickColor, true);
					}
					else
					{
						_this.addRect((380/n)*i, (380/n)*j, 380/n-5, 380/n-5, ranColor, false);
					}
				}
			}
			
			
		}
		
		_this.addTimer = function(){
			output = stage.addChild(new createjs.Text("", "14px monospace", "#000"));
			output.lineHeight = 15;
			output.textBaseline = "top";
			output.x = 0;
			output.y = 380;
		}
		
		_this.addGameOver = function(){
			gameover = stage.addChild(new createjs.Text("", "30px monospace", "#FF0000"));
			gameover.lineHeight = 30;
			gameover.textBaseline = "top";
			gameover.x = 20;
			gameover.y = 180;
		}
		
		_this.addScore = function(){
			score = stage.addChild(new createjs.Text("", "14px monospace", "#000000"));
			score.lineHeight = 15;
			score.textBaseline = "top";
			score.x = 290;
			score.y = 380;
		}

		return _this;
	}
	window.mainView = mainView;
}());



var test2 = new mainView();
//test.addRect(0, 0, 300, 300, "red");
test2.createView();
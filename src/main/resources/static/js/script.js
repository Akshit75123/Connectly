console.log("script loaded")

let currentTheme=getTheme();
changeTheme(currentTheme);

document.addEventListener('DOMContentLoader',()=>{
    changeTheme();
})

function changeTheme()
{
    document.querySelector("html").classList.add(currentTheme);
    
    
    
    const changeThemeButton = document.querySelector('#theme_change_button')
    changeThemeButton.querySelector("span").textContent=currentTheme == "light" ? "Dark": "Light";  

    //set the listener to change theme button
    changeThemeButton.addEventListener("click",(event)=>{
        const oldTheme=currentTheme;
        // console.log("change theme button clicked");
        if (currentTheme=="dark")
            currentTheme="light"
        else 
            currentTheme="dark"
        //update to localstorage 
        setTheme(currentTheme);
        //remove current theme
        document.querySelector('html').classList.remove(oldTheme);
        //set new theme
        document.querySelector('html').classList.add(currentTheme);
        //change the text-button 
        changeThemeButton.querySelector("span").textContent=currentTheme == "light" ? "Dark": "Light";  
    });
}

//set theme to localstorage
function setTheme(theme)
{
    localStorage.setItem("theme",theme);
}

//get theme to localstorage
function getTheme()
{   let theme = localStorage.getItem("theme");
    if (theme) return theme;
    else return "light"
}


const obj=
{
    name:"JS",
    getName:function()
    {
        return function()
        {
            return this.name;
        }
    }
}
console.log(obj.getName()());
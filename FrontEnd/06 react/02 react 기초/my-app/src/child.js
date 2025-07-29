export default function(props){
    console.log("프롭", props);
  return (
    <h1>
    {props.name} {props.age}
    </h1>
  );
}
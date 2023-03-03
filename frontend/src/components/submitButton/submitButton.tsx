import "./submitButton.css"
import {FC} from "react";

const SubmitButton: FC<{ submitForm: () => void }> = (action) => {
    return (<button onClick={action.submitForm}>SUBMIT</button>)
}

export default SubmitButton;
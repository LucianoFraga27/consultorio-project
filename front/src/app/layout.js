import './globals.css'

export const metadata = {
  title: 'Aps 2 - Banco de dados',
  description: 'Projeto criado para faculdade sobre um consultorio medico, aonde fomos solicitados fazer um CRUD de dados',
}

export default function RootLayout({ children }) {
  return (
    <html lang="pt-br">
      <body className='bg-zinc-900 text-zinc-50'>{children}</body>
    </html>
  )
}
